## Release History

### Version 1.0.3 (tbd)

* tbd

### Version 1.0.2 (2018-10-18)

* update to `com.ubirch.util:response-util:0.5.0`

### Version 1.0.1 (2018-10-16)

* update to `com.ubirch.util:deep-check-model:0.3.1`
* update to `com.ubirch.util:mongo-utils:0.8.4`
* update to `com.ubirch.util:mongo-test-utils:0.8.4`
* update to `com.ubirch.util:response-util:0.4.1`

### Version 1.0.0 (2018-10-15)

* renamed `UserContext.userId` to `externalUserId`

### Version 0.12.2 (2018-08-14)

* bugfix: in `UserManager` we had a problem with lower-/upper-cases. user.externalId is now always stored as lower-case and when searching with it we convert to lower-case as well
* minor improvement: all actors now overwirte `unhandled()`

### Version 0.12.1 (2018-08-13)

* bugfix: URI generated in `RouteConstants` were missing uri encoding
* removed dependency on `com.ubirch.util:futures`
* update to `com.ubirch.util:config:0.2.3`
* update to `com.ubirch.util:crypto:0.4.11`
* update to `com.ubirch.util:date:0.5.3`
* update to `com.ubirch.util:json:0.5.1`
* update to `com.ubirch.util:mongo-utils:0.8.3`
* update to `com.ubirch.util:mongo-test-utils:0.8.3`

### Version 0.12.0 (2018-08-04)

* added endpoint `POST /api/userService/v1/register`
* added endpoint `PUT /api/userService/v1/user/info`
* added endpoint `GET /api/userService/v1/user/info/$CONTEXT/$PROVIDER_ID/$EXTERNAL_USER_ID`

### Version 0.11.0 (2018-08-01)

* update to `com.ubirch.util:mongo-utils:0.8.0`
* update to `com.ubirch.util:mongo-test-utils:0.8.0`
* fixed some tests

### Version 0.10.1 (2018-07-31)

* update to `org.json4s:json4s-native:3.6.0`
* update to `com.ubirch.util:deep-check-model:0.3.0`
* update to `com.ubirch.util:json:0.5.0`
* update to `com.ubirch.util:mongo-utils:0.7.0`
* update to `com.ubirch.util:mongo-test-utils:0.7.0`
* update to `com.ubirch.util:response-util:0.4.0`

### Version 0.10.0 (2018-07-31)

* update to Scala 2.11.12
* update to `com.typesafe.akka:akka-(actor|slf4j):2.5.11`
* update to `com.typesafe.akka:akka-http(-testkit):10.1.3`
* update to `com.ubirch.util:config:0.2.1`
* update to `com.ubirch.util:date:0.5.2`
* update to `com.ubirch.util:deep-check-model:0.2.1`
* update to `com.ubirch.util:json:0.4.4`
* update to `com.ubirch.util:mongo-utils:0.6.0`
* update to `com.ubirch.util:mongo-test-utils:0.6.0`
* update to `com.ubirch.util:response-util:0.3.0`
* update to `com.ubirch.util:rest-akka-http:0.4.0`
* update to `com.ubirch.util:rest-akka-http-test:0.4.0`
* update to `com.ubirch.util:json:0.1.3`

### Version 0.9.0 (2018-07-30)

* update sbt from `0.13.17` to `1.1.6`
* update to plugin `com.eed3si9n:sbt-assembly:0.14.7`
* update to plugin `se.marcuslonnberg:sbt-docker:1.5.0`
* update to plugin `org.scoverage:sbt-scoverage:1.5.1`
* update to plugin `net.vonbuchholtz:sbt-dependency-check:0.2.7`
* update to `com.ubirch.util:crypto:0.4.9`

### Version 0.8.5 (tbd)

* register user without email/username    

### Version 0.8.4 (2018-04-11)

* update to `net.logstash.logback:logstash-logback-encoder:5.0`
* update to `com.typesafe.akka:akka-(actor|slf4j):2.4.20`
* update to `com.typesafe.akka:akka-http:10.0.11`
* update to `com.ubirch.util:mongo-utils:0.5.3`
* update to `com.ubirch.util:mongo-test-utils:0.5.3`
* update to `com.ubirch.util:crypto:0.4.7`
* update to `com.ubirch.util:uuid:0.1.2`
* update to `com.ubirch.util:rest-akka-http:0.3.9`
* update to `com.ubirch.util:rest-akka-http-test:0.3.9`
* update to `com.ubirch.util:response-util:0.2.5`

### Version 0.8.3 (2018-03-26)

* add missing export statements in `initUsers.sh`
* update to `com.ubirch.util:mongo-test-utils:0.4.1`
* update to `com.ubirch.util:mongo-utils:0.4.1`
* added handling of broken database connection to deep check

### Version 0.8.2 (2018-03-16)

* bugfix: url in `UserServiceClientRest.userPUT()` was wrong
* bugfix: fixed response status from 202 (Accepted)to 200 (OK) for create user route and update user route

### Version 0.8.1 (2018-03-16)

* add `UserServiceClientRest.userPUT()`

### Version 0.8.0 (2018-03-14)

* add `UserServiceClientRest.userPOST()`
* renamed `UserServiceClientRest.groups()` to `UserServiceClientRest.groupMemberOfGET()`

### Version 0.7.0 (2018-03-08)

* update to `com.ubirch.util:date:0.5.1`
* add `UserServiceClientRest.userDELETE()`
* update to `com.ubirch.util:config:0.2.0`
* update to `com.ubirch.util:mongo-test-utils:0.3.7`
* update to `com.ubirch.util:mongo-utils:0.3.7`

### Version 0.6.4 (2018-01-15)

* add `/user/emailExists/$EMAIL_ADDRESS` endpoint
* add `UserServiceClientRest.emailExistsGET()`

### Version 0.6.3 (2017-09-18)

* removed legacy contexts from contextPrefixList (list of contexts to create through `/initData/$ENVIRONMENT_NAME` endpoint)
* fixed group query bug
* moved some of README's documentation to separate files in newly created folder _docs_
* introduce configurable list of OIDC providers for whom users are automatically activated after registration

### Version 0.6.2 (2017-08-11)

* add `/user/$PROVIDER/$EXTERNAL_USER_ID` endpoint to REST client (see `UserServiceClientRest#userGET`)

### Version 0.6.1 (2017-08-09)

* bugfix: searching for groups based on an ownerId was broken since the queries had not been updated to the new field name (`ownerIds` instead of `ownerId`)
* fixed broken tests

### Version 0.6.0 (2017-08-07)

* add context _trackle_ to InitData
* refactored field `Group.ownerId: String|UUID` to a set (in DB and REST models)

### Version 0.5.1 (2017-07-31)

* fixed some scaladoc
* update to `com.ubirch.util:mongo-utils:0.3.6`
* update to `com.ubirch.util:mongo-test-utils:0.3.6`

### Version 0.5.0 (2017-07-28)

* refactor `UserServiceClientRest.deepCheck` to return `DeepCheckResponse` (without Option)
* refactor `UserServiceClientRest.deepCheck` responses to include a `[user-service]` prefix in all it's messages

### Version 0.4.21 (2017-07-28)

* change context name from _trackle-$env_ to _trackle-ui-$env_

### Version 0.4.20 (2017-07-27)

* add method `UserServiceClientRest#check`
* add method `UserServiceClientRest#deepCheck`

### Version 0.4.19 (2017-07-27)

* add `initUser.sh`
* update to `com.ubirch.util:json:0.4.3`
* update to `com.ubirch.util:deep-check-model:0.1.3`
* update to `com.ubirch.util:response-util:0.2.4`
* update to `com.ubirch.util:mongo-test-utils:0.3.5`
* update to `com.ubirch.util:mongo-utils:0.3.5`

### Version 0.4.18 (2017-07-24)

* revert to Akka 2.4.19
* refactor `UserServiceClientRest` to use Akka Http for the connection

### Version 0.4.17 (2017-07-18)

* update to Akka 2.4.19
* update to Play 2.5.3
* update _com.ubirch.util:mongo(-test)-utils_ to 0.3.4

### Version 0.4.16 (2017-07-17)

* change `com.ubirch.user.core.manager.GroupsManager.findByContextAndUser` to return only groups where the given user is the owner

### Version 0.4.15 (2017-07-17)

* update _com.ubirch.util:rest-akka-http(-test)_ to 0.3.8
* update _com.ubirch.util:response-util_ to 0.2.3

### Version 0.4.14 (2017-07-13)

* fixed bug in dev script
* update logging dependencies
* update logback configs
* update _com.ubirch.util:mongo(-test)-utils_ to 0.3.3

### Version 0.4.13 (2017-06-29)

* switch from dependency _play-ahc-ws-standalone:1.0.0-M10_ to _play-ws:2.4.11_ to fix a bug where we get runtime errors
  using the REST clients from user-service and key-service in the same project

### Version 0.4.12 (2017-06-29)

* add script `dev-scripts/resetDatabase.sh`
* refactored actors by adding a `props()` method
* updated to _com.ubirch.util:json:0.4.2_ and all ubirch util libs depending on it, too

### Version 0.4.11 (2017-06-22)

* bugfix (UBI-264): updates on Azure's CosmosDB show the behavior of an upsert()

### Version 0.4.10 (2017-06-19)

* update json4s to 3.5.2
* update to _com.ubirch.util:json:0.4.1_
* update to _com.ubirch.util:deep-check-model:0.1.1_
* update to _com.ubirch.util:mongo-test-utils:0.3.1_
* update to _com.ubirch.util:mongo-utils:0.3.1_
* update to _com.ubirch.util:response-util:0.2.1_

### Version 0.4.9 (2017-06-12)

* endpoint `/api/userService/v1/deepCheck` responds with http status 503 if deep check finds problems

### Version 0.4.8 (2016-06-09)

* migrate to _com.ubirch.util:deep-check-model:0.1.0_

### Version 0.4.7 (2017-06-08)

* update _com.ubirch.util:mongo-test-utils_ to 0.2.3
* update _com.ubirch.util:mongo-utils_ to 0.2.3
* introduce `DeepCheckManager`

### Version 0.4.6 (2017-06-07)

* introduce endpoint `/api/authService/v1/check`
* update to sbt 0.13.15
* update to _com.ubirch.util:json:0.4.0_
* update to _com.ubirch.util:response-util:0.1.6_
* introduce endpoint `/api/userService/v1/deepCheck`

### Version 0.4.5 (2017-05-31)

* added field `User.activeUser` to REST model

### Version 0.4.4 (2017-05-31)

* improve documentation
* fixed bug that broke `InitUsers`
* added activeUser flag to user 

### Version 0.4.3 (2017-05-31)

* deleted `group/byName/$GROUP_NAME` routes

### Version 0.4.2 (2017-05-30)

* fixed http response codes and error messages in `GroupRoute`
* updated documentation in README

### Version 0.4.1 (2017-05-29)

* update `DataHelpers` in module `test-tools-ext` to allow creation of admin groups

### Version 0.4.0 (2017-05-29)

* add field _adminGroup_ to REST and DB model of `Group`

### Version 0.3.2 (2017-05-24)

* `InitData` inits all users with a group now (before only user1 had a group)
* replaced `InitData` with `InitUsers`
* introduced endpoint `/initData/$ENV_NAME`

### Version 0.3.1 (2017-05-22)

* update dependency `rest-akka-http` to 0.3.7
* update dependency `rest-akka-http-test` to 0.3.7
* replace path `/groups` with `/group/memberOf`

### Version 0.3.0 (2017-05-18)

* update dependency `rest-akka-http` to 0.3.6
* update dependency `rest-akka-http-test` to 0.3.6
* update dependency `response-util` to 0.1.4
* update dependency `mongo-utils` to 0.2.2
* update dependency `mongo-test-utils` to 0.2.2
* update to Akka HTTP 10.0.6
* update to Akka 2.4.18
* add module `client-rest`

### Version 0.2.0 (2017-05-05)

* update all models to use `String` instead of `UUID`

### Version 0.1.1 (2017-05-02)

* try to fix problem where a config key is not found

### Version 0.1.0 (2017-05-02)

* initial release
