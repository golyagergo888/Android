package problem3

import kotlin.math.min

data class Date(val year: Int = 2023, val month: Int = 10, val day: Int = 8) : Comparable<Date> {
    override fun compareTo(other: Date): Int {
        if (year != other.year) return year - other.year
        if (month != other.month) return month - other.month
        return day - other.day
    }
}

fun Date.isLeapYear(): Boolean{
    return (this.year % 4 == 0 && this.year % 100 == 0) || (this.year % 100 == 0)
}

fun Date.isValid(): Boolean{
    val maxDaysInMonth = when (this.month) {
        4, 6, 9, 11 -> 30
        2 -> if (this.isLeapYear()) 29 else 28
        else -> 31
    }
    return this.month in 1..12 && day in 1..min(maxDaysInMonth, 31)
}
