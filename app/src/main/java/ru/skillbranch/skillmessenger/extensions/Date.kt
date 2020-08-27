package ru.skillbranch.skillmessenger.extensions

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

const val fullDateFormat = "HH:mm:ss dd:MM:yy"

fun Date.format(pattern: String = fullDateFormat): String {
    return SimpleDateFormat(pattern, Locale.getDefault()).format(this)
}

fun Date.add(value: Int, units: TimeUnit = TimeUnit.SECONDS): Date {
    var time = this.time
    time += when (units) {
        TimeUnit.SECONDS -> value * SECOND
        TimeUnit.MINUTES -> value * MINUTE
        TimeUnit.HOURS -> value * HOUR
        TimeUnit.DAYS -> value * DAY
        else -> throw UnsupportedOperationException("Unsupported time unit")
    }
    this.time = time
    return this
}