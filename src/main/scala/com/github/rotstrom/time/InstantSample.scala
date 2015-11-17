package com.github.rotstrom.time

import java.time.{ZoneId, LocalDateTime, Instant}
import java.time.temporal.ChronoUnit.{MINUTES, HOURS}
import java.time.temporal.ChronoUnit

/**
 * time from epoch (Jan, 01, 1970)
 * before - negative values
 * after - positive values
 * ZoneDateTime and OffsetTimeZone could be converted to Instant
 * reverse isn't true - OffsetDateTime requires
 */
object InstantSample extends App {
  val epoch = Instant.EPOCH
  val epochInc = epoch.plus(2, HOURS)

  println(epochInc)
  if (epochInc.isAfter(epoch)) println(s"$epochInc is really after $epoch")

  def diff(unit: ChronoUnit) = epoch.until(epochInc, unit)

  println(s"Between $epoch and $epochInc: ${diff(HOURS)} $HOURS")
  println(s"Between $epoch and $epochInc: ${MINUTES.between(epoch, epochInc)} $MINUTES")


  val ldt = LocalDateTime.ofInstant(epoch, ZoneId.systemDefault())
  println(ldt)
}
