package problem3

import kotlin.math.min
import java.util.Random

fun main() {
    val random = Random()
    println("The random number: ${random.nextInt()}")
    val validDates = mutableListOf<Date>()

    while (validDates.size < 10) {
        val year = random.nextInt(25) + 2000
        val month = random.nextInt(12) + 1
        val day = random.nextInt(31) + 1

        val date = Date(year, month, day)

        if (date.isValid()) {
            validDates.add(date)
        } else {
            println("$date is not a valid date.")
        }
    }

    println("\nValid Dates:")
    validDates.forEach { println(it) }

    validDates.sort()
    println("\nSorted dates:")
    validDates.forEach { println(it) }

    validDates.reverse()
    println("\nReversed sorted dates:")
    validDates.forEach { println(it) }

    val customComparator = Comparator<Date> { date1, date2 ->
        if (date1.year != date2.year) date1.year - date2.year
        else if (date1.month != date2.month) date1.month - date2.month
        else date1.day - date2.day
    }

    validDates.sortWith(customComparator)
    println("\nCustom sorted dates:")
    validDates.forEach { println(it) }
}