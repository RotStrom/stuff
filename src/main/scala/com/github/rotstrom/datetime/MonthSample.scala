package com.github.rotstrom.datetime

import java.time.Month
import java.time.format.TextStyle
import java.util.Locale

/**
 * month representation
 */
object MonthSample extends App {
  Month.values.foreach(month =>
    println(s"Maximum of days in ${month.getDisplayName(TextStyle.FULL, Locale.getDefault)}: ${month.maxLength()}")
  )
}
