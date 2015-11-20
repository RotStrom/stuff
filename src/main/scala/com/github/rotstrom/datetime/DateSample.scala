package com.github.rotstrom.datetime

import java.time._
import java.time.format.TextStyle
import java.util.Locale

object DateSample extends App {

  implicit class RichDay(from: DayOfWeek) {
    val locale = Locale.getDefault
    val style = TextStyle.FULL

    def toLocal: String = {
      from.getDisplayName(style, locale)
    }
  }

  val day = DayOfWeek.MONDAY
  val i = 3

  println(s"${day.toLocal} plus $i days is a ${day.plus(i).toLocal}.")
}







