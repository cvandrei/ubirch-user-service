package com.ubirch.user.server.route

import akka.actor.ActorSystem
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.pattern.ask
import akka.util.Timeout
import com.typesafe.scalalogging.slf4j.StrictLogging
import com.ubirch.user.config.Config
import com.ubirch.user.core.actor.{ActorNames, DeepCheckActor}
import com.ubirch.user.util.server.RouteConstants
import com.ubirch.util.deepCheck.model.{DeepCheckRequest, DeepCheckResponse}
import com.ubirch.util.http.response.ResponseUtil
import com.ubirch.util.model.JsonErrorResponse
import com.ubirch.util.mongo.connection.MongoUtil
import com.ubirch.util.rest.akka.directives.CORSDirective
import de.heikoseeberger.akkahttpjson4s.Json4sSupport._

import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.util.{Failure, Success}

/**
  * author: cvandrei
  * since: 2017-06-07
  */
class DeepCheckRoute(implicit mongo: MongoUtil, system: ActorSystem) extends CORSDirective
  with ResponseUtil
  with StrictLogging {

  implicit val executionContext: ExecutionContextExecutor = system.dispatcher
  implicit val timeout: Timeout = Timeout(Config.actorTimeout seconds)

  private val deepCheckActor = system.actorOf(DeepCheckActor.props(), ActorNames.DEEP_CHECK)

  val route: Route = {

    path(RouteConstants.deepCheck) {
      respondWithCORS {
        get {

          onComplete(deepCheckActor ? DeepCheckRequest()) {

            case Failure(t) =>
              logger.error("failed to run deepCheck (check DeepCheckRoute for bugs!!!)", t)
              complete(serverErrorResponse(errorType = "ServerError", errorMessage = "sorry, something went wrong on our end"))

            case Success(resp) =>
              resp match {

                case res: DeepCheckResponse if res.status =>
                  complete(StatusCodes.OK -> res)
                case res: DeepCheckResponse if !res.status =>
                  complete(response(responseObject = res, status = StatusCodes.ServiceUnavailable))
                case jer: JsonErrorResponse =>
                  complete(StatusCodes.InternalServerError -> jer)
                case _ => complete(serverErrorResponse(errorType = "ServerError", errorMessage = "failed to run deep check"))

              }

          }

        }
      }
    }

  }

}
