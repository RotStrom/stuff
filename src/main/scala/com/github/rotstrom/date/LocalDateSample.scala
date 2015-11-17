package com.github.rotstrom.date

import java.time.format.TextStyle
import java.time.temporal.TemporalAdjusters
import java.time.{DayOfWeek, LocalDate, Month}
import java.util.Locale

/**
 * year-month-day (without time)
 */
object LocalDateSample extends App {
  val someDate = LocalDate.of(2015, Month.NOVEMBER, 17)
  val someDateDay = someDate.getDayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault)
  val nextFriday = someDate.`with`(TemporalAdjusters.next(DayOfWeek.FRIDAY))
  println(s"Next friday after $someDate ($someDateDay) is $nextFriday.")
}
