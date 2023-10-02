package problem1

import java.util.Base64
import kotlin.random.Random

fun exercise1(){
    val a = 2
    val b = 3
    val sum = a + b
    println("Sum: ${sum}")
}

fun exercise2(){
    val days = listOf("Monday", "Tuesday", "Wednesday","Thursday","Friday","Saturday","Sunday")
    for (day in days) {
        print(day + ", ")
    }
    println();
    print("Days with T in the start: ")
    days.filter{it.startsWith("T")}.forEach{print(it)}
    println()
    print("Days wich contains the letter e: ")
    days.filter{it.contains("e")}.forEach{print(it)}
    println()
    print("Days wich has 6 lenght: ")
    days.filter{it.length == 6 }.forEach{print(it + ", ") }
}

fun list_array(){
    // List
    val fruits = mutableListOf("apple", "cherry", "lime")
    fruits.add("watermelon")
    fruits.remove("lime")

    val filteredFruits = fruits.filter { it.startsWith("A") }
    val lengths = fruits.map { it.length }

    fruits.forEach { println(it) }
    if (fruits.any { it.length > 5 }) {
        println("Fruits wich has 5 lenght.")
    }

    val sortedFruits = fruits.sortedBy { it.length }

    // Array
    val numbers = arrayOf(1, 2, 3, 4, 5)
    val firstNumber = numbers[0]
    numbers[3] = 42

    val filteredNumbers = numbers.filter { it % 2 == 0 }
    val doubledNumbers = numbers.map { it * 2 }

    numbers.forEach { println(it) }
    numbers[3] = 9
    if (numbers.all { it < 10 }) {
        println("All numbers are less then 10.\n")
    }

    val sortedNumbers = numbers.sortedByDescending { it }
}

fun isPrime(a:Int) :Boolean{
    if (a <= 1) {
        return false
    }
    if (a <= 3) {
        return true
    }
    if (a % 2 == 0 || a % 3 == 0) {
        return false
    }

    var i = 5
    while (i * i <= a) {
        if (a % i == 0 || a % (i + 2) == 0) {
            return false
        }
        i += 6
    }

    return true
}

fun isEven(number:Int):Boolean{
    return number % 2 == 0
}

fun isEven2(number:Int) = number % 2 == 0

fun encode(text: String): String{
    return Base64.getEncoder().encodeToString(text.toByteArray())
}

fun decode(text: String): String{
    return String(Base64.getDecoder().decode(text))
}

fun main(args: Array<String>) {
    print("Exercices:")
    println();
    val number = 1
    var number2 = 2
    println("number: " + number)
    println("number2: " + number2)
    //	number = 3; <- immutable
    number2 = 4
    println("number: " + number)
    println("number2: " + number2)
    number2 = 3 + 4
    println("number2: " + number2)
    var arr = listOf("one", "two")
    println(arr)

    //	functions
    println()
    println("First Exercise sum of two numbers:")
    exercise1()
    println()
    println("Second Exercise days of week in list:")
    exercise2()
    println("\n")
    println("Lists and arrays:")
    list_array()
    println("Third Exercise isPrime:")
    println(isPrime(2))
    println()
    println("Fourth Exercise isEven:");
    println(isEven(2))
    println("Fourth Exercise isEven2:");
    println(isEven2(2))

    // encode-decode-hashing
    println()
    println("Encoded text:");
    println(encode("Koncz Hunor baba"))
    println("Decoded text:");
    println(decode("S29uY3ogSHVub3IgYmFiYQ=="))

    // HOMEWORK
//    5
    println("\n\tHOMEWORK")
    println("\tTask 5:")
    printEvenNumbers(listOf( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ))
//    6
    val days = listOf("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday")
    println("\n\tTask 6:")
    // a
    doubleElements(listOf( 1, 2, 3, 4, 5, 6 ))
    println()
    // b
    capitalizedDays(days)
    println()
    // c
    firstCharOfCapitalizedDays(days)
    println()
    // d
    lengthOfTheDays(days)
    println()
    // e
    println("${days.map { it.length }.sum()}, ${days.size} => ${String.format("%.2f", (days.map { it.length }.sum().toDouble() / days.size))}")
    print(averageLengthOfTheDays(days))
//    7
    println("\n\tTask 7:")
    val iDays = mutableListOf<String>()
    iDays.addAll(days)
    // a
    removeN(iDays)
    println()
    // b
    removeNAndIndex(iDays)
    // c
    sortRemovedNDays(iDays)
//    8
    println("\n\tTask 8:")
    val randomIntegers = Array<Int>(10) { Random.nextInt(101) }
    // a
    randomIntegers.forEach {print("${it}, ") }
    println()
    // b
    sortRandomArray(randomIntegers)
    println()
    // c
    print(randomContainsEven(randomIntegers))
    println()
    // d
    print(randomAllEven(randomIntegers))
    println()
    //e
    avgRandomArray(randomIntegers)
}

fun printEvenNumbers(numbers: List<Int>) = numbers.filter { it % 2 == 0 }.forEach{print("${it}, ") }

fun doubleElements(numbers: List<Int>) = numbers.map {it * 2}.forEach{print("${it}, ") }

fun capitalizedDays(days: List<String>) = days.map { it.capitalize() }.forEach{print("${it}, ") }

fun firstCharOfCapitalizedDays(days: List<String>) = days.map { it.toLowerCase().first() }.forEach{print("${it}, ") }

fun lengthOfTheDays(days: List<String>) = days.map { it.capitalize() }.forEach{print("${it} -> ${it.length}, ") }

fun averageLengthOfTheDays(days: List<String>) = days.map { it.length }.sum() / days.size

fun removeN(days: MutableList<String>) = days.filter { !it.contains('n') }.forEach{print( "${it.capitalize()}, ")}

fun removeNAndIndex(days: MutableList<String>){
    days.removeIf { it.contains('n') }

    for ((index, day) in days.withIndex()) {
        println("Item at $index is ${day.capitalize()}")
    }
}

fun sortRemovedNDays(days: MutableList<String>){
    days.removeIf { it.contains('n') }
    days.sort()
    for (day in days) {
        print(day.capitalize() + ", ")
    }
}

fun sortRandomArray(array: Array<Int>){
    array.sort();
    array.forEach{print( "${it}, ")}
}

fun randomContainsEven(array: Array<Int>) = array.any{ it % 2 == 0 }

fun randomAllEven(array: Array<Int>) = array.all{ it % 2 == 0 }

fun avgRandomArray(array: Array<Int>){
    val sum = array.sum()

    val average = if (array.isNotEmpty()) sum.toDouble() / array.size else 0.0

    println("Sum: ${sum}, Average: $average")
}
