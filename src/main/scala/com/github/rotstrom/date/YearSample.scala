package com.github.rotstrom.date

import java.time.Year

object YearSample extends App {
  val year = Year.of(2012)

  if (year.isLeap) println(s"Year $year is leap.")
}
