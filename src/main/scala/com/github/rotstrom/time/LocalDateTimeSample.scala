package com.github.rotstrom.time

import java.time.{LocalTime, Month, LocalDate, LocalDateTime}

/**
 * local date and time, without zone
 */
object LocalDateTimeSample extends App {
  val ldt = LocalDateTime.of(LocalDate.of(2012, Month.FEBRUARY, 20), LocalTime.of(20, 20))
  val ldt2 = LocalDateTime.of(2012, Month.FEBRUARY, 20, 20, 20)

  println(ldt.equals(ldt2))
  println(ldt.plusHours(2))
}
