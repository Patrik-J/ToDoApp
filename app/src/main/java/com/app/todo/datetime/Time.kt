package com.app.todo.datetime

import java.time.LocalTime
import java.time.format.DateTimeFormatter

const val format24: String = "HH:mm"
const val format12: String = "hh:mm"

const val STANDARD_TIME_FORMAT = format24

fun reformatTimeToString(time: LocalTime, format: String): String {
    return time.format(DateTimeFormatter.ofPattern(format))
}

fun reformatTimeString(time: String, format: String): String {
    val realTime = timeStringToLocalTime(time, STANDARD_TIME_FORMAT)
    return reformatTimeToString(realTime, format)
}

fun localTimeToStandardFormatString(time: LocalTime): String {
    return reformatTimeToString(time, STANDARD_TIME_FORMAT)
}

fun getStandardTime(): String {
    val time = LocalTime.now()
    return localTimeToStandardFormatString(time)
}

fun timeStringToLocalTime(time: String, format: String): LocalTime {
    val realTime = LocalTime.parse(time, DateTimeFormatter.ofPattern(format))
    return realTime
}
