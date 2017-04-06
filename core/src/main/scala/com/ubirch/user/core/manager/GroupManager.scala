package com.ubirch.user.core.manager

import java.util.UUID

import com.typesafe.scalalogging.slf4j.StrictLogging

import com.ubirch.user.config.Config
import com.ubirch.user.model.db.Group
import com.ubirch.util.mongo.connection.MongoUtil
import com.ubirch.util.mongo.format.MongoFormats

import reactivemongo.bson.{BSONDocumentReader, BSONDocumentWriter, Macros, document}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * author: cvandrei
  * since: 2017-03-30
  */
object GroupManager extends StrictLogging
  with MongoFormats {

  private val collection = Config.mongoCollectionGroup

  implicit protected def groupWriter: BSONDocumentWriter[Group] = Macros.writer[Group]

  implicit protected def groupReader: BSONDocumentReader[Group] = Macros.reader[Group]

  def create(group: Group)(implicit mongo: MongoUtil): Future[Option[Group]] = {

    mongo.collection(collection) map { collection =>

      try {
        collection.insert[Group](group) onComplete {

          case Failure(e) =>
            logger.error("failed to create group", e)
            throw e

          case Success(_) => logger.debug(s"created new group: $group")

        }
      } catch {
        case t: Throwable => None
      }
      Some(group)

    }

  }

  def update(group: Group)(implicit mongo: MongoUtil): Future[Option[Group]] = {

    val selector = document("id" -> group.id)
    mongo.collection(collection) flatMap {

      _.update(selector, group) map { writeResult =>

        if (writeResult.ok && writeResult.n == 1) {
          logger.info(s"updated group: id=${group.id}")
          Some(group)
        } else {
          logger.error(s"failed to update group: group=$group")
          None
        }

      }

    }

  }

  def findById(id: UUID)(implicit mongo: MongoUtil): Future[Option[Group]] = {

    val selector = document("id" -> id)

    mongo.collection(collection) flatMap {
      _.find(selector).one[Group]
    }

  }

  def delete(id: UUID)(implicit mongo: MongoUtil): Future[Boolean] = {

    val selector = document("id" -> id)

    mongo.collection(collection) flatMap {
      _.remove(selector) map { writeResult =>

        if (writeResult.ok && writeResult.n == 1) {
          logger.info(s"deleted group: id=$id")
          true
        } else {
          logger.error(s"failed to delete group: id=$id (writeResult=$writeResult)")
          false
        }

      }
    }

  }

  def addAllowedUsers(groupId: UUID, allowedUsers: Seq[UUID]): Future[Boolean] = {

    // TODO implement
    Future(true)

  }

  def deleteAllowedUsers(groupId: UUID, allowedUsers: Seq[UUID]): Future[Boolean] = {

    // TODO implement
    Future(true)

  }

}
