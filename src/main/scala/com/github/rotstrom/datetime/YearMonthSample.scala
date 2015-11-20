package com.github.rotstrom.datetime

import java.time.{Month, YearMonth}

/**
 * month of a specific year
 */
object YearMonthSample extends App {
  val date = YearMonth.of(2010, Month.FEBRUARY)
  val date2 = YearMonth.of(2012, Month.FEBRUARY)

  def printNumberOfDays(date: YearMonth): Unit = {
    println(s"Number of days in ${date.getMonth} of ${date.getYear} is ${date.lengthOfMonth()}.")
  }

  printNumberOfDays(date)
  printNumberOfDays(date2)
}
