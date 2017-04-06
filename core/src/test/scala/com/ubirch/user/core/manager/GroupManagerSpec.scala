package com.ubirch.user.core.manager

import com.ubirch.user.config.Config
import com.ubirch.user.testTools.db.mongo.{DefaultModels, MongoSpec}
import com.ubirch.util.uuid.UUIDUtil

/**
  * author: cvandrei
  * since: 2017-04-06
  */
class GroupManagerSpec extends MongoSpec {

  private val collection = Config.mongoCollectionGroup

  feature("create()") {

    scenario("group does NOT exist --> success") {

      // prepare
      val group = DefaultModels.group()

      // test
      GroupManager.create(group) flatMap { created =>

        // verify
        created shouldBe Some(group)
        mongoTestUtils.countAll(collection) map (_ shouldBe 1)

      }

    }

    ignore("group already exists --> fail") {

      // TODO test ist broken --> fix me!!!
      // prepare
      GroupManager.create(DefaultModels.group()) flatMap {

        case None => fail("failed during preparation")

        case Some(existingGroup) =>

          // test
          GroupManager.create(existingGroup) flatMap { created =>

            // verify
            created shouldBe None
            mongoTestUtils.countAll(collection) map (_ shouldBe 1)

          }

      }

    }

  }

  feature("update()") {

    scenario("group.id does not exist --> fail") {

      // prepare
      val group = DefaultModels.group()

      // test
      GroupManager.update(group) flatMap { updated =>

        // verify
        updated shouldBe None
        mongoTestUtils.countAll(collection) map (_ shouldBe 0)

      }

    }

    scenario("group.id exists --> success") {

      // prepare
      GroupManager.create(DefaultModels.group()) flatMap {

        case None => fail("failed during preparation")

        case Some(group) =>

          val update = group.copy(displayName = s"${group.displayName}-test")

          // test
          GroupManager.update(update) flatMap { result =>

            // verify
            result shouldBe Some(update)
            mongoTestUtils.countAll(collection) map (_ shouldBe 1)

          }

      }

    }

  }

  feature("findById()") {

    scenario("group.id does not exist --> fail") {

      // test
      GroupManager.findById(UUIDUtil.uuid) flatMap { created =>

        // verify
        created shouldBe None
        mongoTestUtils.countAll(collection) map (_ shouldBe 0)

      }

    }

    scenario("group.id exists --> success") {

      // prepare
      GroupManager.create(DefaultModels.group()) flatMap {

        case None => fail("failed during preparation")

        case Some(group) =>

          // test
          GroupManager.findById(group.id) flatMap { result =>

            // verify
            result shouldBe Some(group)
            mongoTestUtils.countAll(collection) map (_ shouldBe 1)

          }

      }

    }

  }

  feature("delete()") {

    scenario("group.id does not exist --> fail") {

      // test
      GroupManager.delete(UUIDUtil.uuid) flatMap { result =>

        // verify
        result shouldBe false
        mongoTestUtils.countAll(collection) map (_ shouldBe 0)

      }

    }

    scenario("group.id exists --> success") {

      // prepare
      GroupManager.create(DefaultModels.group()) flatMap {

        case None => fail("failed during preparation")

        case Some(user) =>

          // test
          GroupManager.delete(user.id) flatMap { result =>

            // verify
            result shouldBe true
            mongoTestUtils.countAll(collection) map (_ shouldBe 0)

          }

      }

    }

  }

}
