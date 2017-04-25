package com.ubirch.user.cmd

import com.typesafe.scalalogging.slf4j.StrictLogging

import com.ubirch.user.config.ConfigKeys
import com.ubirch.user.model.db.{Context, Group, User}
import com.ubirch.user.testTools.external.DataHelpers
import com.ubirch.util.mongo.connection.MongoUtil

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * author: cvandrei
  * since: 2017-04-07
  */
object InitData extends App
  with StrictLogging {

  private implicit val mongo = new MongoUtil(ConfigKeys.MONGO_PREFIX)

  private val dataHelpers = new DataHelpers

  val dataCreated = for {

    contextUbirchOpt <- dataHelpers.createContext(displayName = "ubirch-dev")
    contextTrackleOpt <- dataHelpers.createContext(displayName = "trackle-dev")
    ownerOpt <- dataHelpers.createUser(displayName = "test-user-1", externalId = "1234")
    user2Opt <- dataHelpers.createUser(displayName = "test-user-2", externalId = "1235")
    user3Opt <- dataHelpers.createUser(displayName = "test-user-3", externalId = "1236")
    groupOpt <- dataHelpers.createGroup(contextUbirchOpt, ownerOpt, user2Opt)

  } yield {

    mongo.close()

    if (contextUbirchOpt.isDefined) {
      logger.info(s"=== created context: name=${contextUbirchOpt.get.displayName}")
    }
    if (contextTrackleOpt.isDefined) {
      logger.info(s"=== created context: name=${contextTrackleOpt.get.displayName}")
    }

    CreatedData(contextUbirchOpt.get, ownerOpt.get, groupOpt.get, user2Opt.get, user3Opt.get)

  }

  dataCreated map { created =>

    val owner = created.owner
    val ownerString = s"id=${owner.id}; provider=${owner.providerId}; externalId=${owner.externalId}"
    logger.info(s"=== created user (owner): $ownerString")

    for (user <- created.allowedUsers) {
      val userString = s"id=${user.id}; provider=${user.providerId}; externalId=${user.externalId}"
      logger.info(s"=== created user (allowedUser): $userString")
    }

    logger.info(s"=== created group: id=${created.group.id}; id=${created.group.displayName}")

  }

}

case class CreatedData(context: Context, owner: User, group: Group, allowedUsers: User*)