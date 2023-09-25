package main

fun main(args: Array<String>) {
    print("Exercices:");
    println();
    val number = 1;
    var number2 = 2;
    println("number: " + number);
    println("number2: " + number2);
    //	asd = 3; <- immutable
    number2 = 4;
    println("number: " + number);
    println("number2: " + number2);
    number2 = 3 + 4;
    println("number2: " + number2);
    var arr = listOf("one", "two");
    println(arr);

    //	functions
    println()
    println("First Exercise sum of two numbers:");
    exercise1();
    println();
    println("Second Exercise days of week in list:");
    exercise2();
    println("\n");
    println("Third Exercise isPrime:");
    println(isPrime(2));
    println();
    println("Fourth Exercise isEven:");
    println(isEven(2));
}

fun exercise1(){
    val a = 2;
    val b = 3;
    val sum = a + b;
    println("Sum: ${sum}");
}

fun exercise2(){
    val days = listOf("Monday", "Tuesday", "Wednesday","Thursday","Friday","Saturday","Sunday");
    for (day in days) {
        print(day + ", ");
    }
    println();
    print("Days with T in the start: ")
    days.filter{it.startsWith("T")}.forEach{print(it)};
    println();
    print("Days wich contains the letter e: ")
    days.filter{it.contains("e")}.forEach{print(it)};
    println();
    print("Days wich has 6 lenght: ")
    days.filter{it.length == 6 }.forEach{print(it + ", ") };
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
