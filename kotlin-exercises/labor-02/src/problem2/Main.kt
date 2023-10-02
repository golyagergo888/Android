package problem2

fun String.monogram(): String = this.split(" ").map{ it[0] }.joinToString("")

fun List<String>.separator(separator: String): String = this.joinToString(separator)

fun List<String>.longest(): String? = this.maxByOrNull { it.length }

fun main(args: Array<String>) {
    val name = "John Smith"
    print(name.monogram() + ", ")
    println("Konc Huni".monogram())

    val myList = listOf("apple", "pear", "strawberry", "melon")
    println(myList.separator("#"))

    println("longest: " + myList.longest()) // Output: "Longest: strawberry"
}

