package com.github.rotstrom.datetime

import java.time.Year

object YearSample extends App {
  val year = Year.of(2012)

  if (year.isLeap) println(s"Year $year is leap.")
}
