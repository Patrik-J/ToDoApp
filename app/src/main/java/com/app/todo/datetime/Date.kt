package com.app.todo.datetime

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.concurrent.TimeUnit

const val dottedDate: String = "dd.MM.yyyy"

const val dashedDate: String = "dd-MM-yyyy"

const val dashedDateReverseDY: String = "yyyy-MM-dd"

const val slashedDate: String = "dd/MM/yyyy"

const val slashedDateReverseDY: String = "yyyy/MM/dd"

const val namedMonth: String = "dd MMM yyyy"

const val STANDARD_DATE_FORMAT: String = dottedDate

fun reformatDateToString(date: LocalDate, format: String): String {
    return date.format(DateTimeFormatter.ofPattern(format))
}

fun reformatDateString(date: String, format: String): String {
    val realDate = dateStringToLocalDate(date, STANDARD_DATE_FORMAT)
    return reformatDateToString(realDate, format)
}

fun localDateToStandardFormatString(date: LocalDate): String {
    return reformatDateToString(date, STANDARD_DATE_FORMAT)
}

fun getStandardDate(): String {
    val date = LocalDate.now()
    return localDateToStandardFormatString(date)
}

fun dateStringToLocalDate(date: String, format: String): LocalDate {
    val realDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(format))
    return realDate
}

fun millisToLocalDate(millis: Long): LocalDate {
    val date = Date(millis)
    val dateString = SimpleDateFormat(STANDARD_DATE_FORMAT).format(date)

    return dateStringToLocalDate(dateString, STANDARD_DATE_FORMAT)
}