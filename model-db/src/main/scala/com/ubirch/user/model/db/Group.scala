package com.ubirch.user.model.db

import com.ubirch.util.date.DateUtil
import com.ubirch.util.uuid.UUIDUtil

import org.joda.time.DateTime

/**
  * author: cvandrei
  * since: 2017-03-29
  */
case class Group(id: String = UUIDUtil.uuidStr,
                 displayName: String,
                 ownerIds: Set[String],
                 contextId: String,
                 allowedUsers: Set[String],
                 adminGroup: Option[Boolean] = None,
                 created: DateTime = DateUtil.nowUTC,
                 updated: DateTime = DateUtil.nowUTC
                )
