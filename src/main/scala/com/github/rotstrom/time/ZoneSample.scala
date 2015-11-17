package com.github.rotstrom.time

import java.time.{LocalDateTime, Month, ZoneId}

import scala.collection.JavaConversions._

/**
 * ZoneId - time zone identifier and rules for converting between Instant and LocalDateTime
 * ZoneOffset - time zone offset from Greenwich/UTC time
 */
object ZoneSample extends App {
  val zoneList = ZoneId.getAvailableZoneIds
  val dt = LocalDateTime.of(2012, Month.JANUARY, 1, 0, 0)

  zoneList.toList.sorted.foreach { zoneStr =>
    val zone = ZoneId.of(zoneStr)
    val zdt = dt.atZone(zone)

    val offset = zdt.getOffset

    // Write only time zones that do not have a whole hour offset
    // to standard out.
    if (offset.getTotalSeconds % (60 * 60) != 0) println(s"$zone: $offset")
  }
}
