package com.ubirch.user.client.rest

import com.typesafe.scalalogging.slf4j.StrictLogging

import com.ubirch.user.client.rest.config.UserClientRestConfig
import com.ubirch.user.model.rest.Group

import play.api.libs.json._
import play.api.libs.ws.StandaloneWSClient

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * author: cvandrei
  * since: 2017-05-15
  */
object UserServiceClientRest extends StrictLogging {

  implicit protected val groupRead: Reads[Group] = Json.reads[Group]

  def groups(contextName: String,
             providerId: String,
             externalUserId: String)
            (implicit ws: StandaloneWSClient): Future[Option[Set[Group]]] = {

    logger.debug("groups(): query groups through REST API")
    val url = UserClientRestConfig.groups(
      contextName = contextName,
      providerId = providerId,
      externalUserId = externalUserId
    )

    // TODO how about connection pooling? is it built in?
    try {

      ws.url(url).get() map { res =>

        if (200 == res.status) {
          logger.debug(s"groups(): got groups: ${res.body}")
          res.json.asOpt[Set[Group]]
        } else {
          logger.error(s"call to user-service REST API failed: status=${res.status}, body=${res.body}")
          None
        }

      }

    } catch {
      case e: Exception =>
        logger.error("groups() failed with an Exception", e)
        Future(None)
      case re: RuntimeException =>
        logger.error("groups() failed with a RuntimeException", re)
        Future(None)
    }

  }

}
