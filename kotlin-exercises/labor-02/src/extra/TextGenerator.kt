package extra

import java.util.Random

class TextGenerator {
    private val mapForWords = mutableMapOf<String, MutableList<String>>()

    fun learnWords(input: String){
        val words = input.split(" ")
        for (i in 0 until words.size - 2) {
            val prefix = "${words[i]} ${words[i + 1]}"
            val postfix = words[i + 2]
            mapForWords.getOrPut(prefix) { mutableListOf() }.add(postfix)
        }
    }

    fun generateText(prefix: String, length: Int): String {
        val words = prefix.split(" ").toMutableList()
        println("${words[0]} ${words[1]} (the first two words)")

        for (i in 2..length) {
            val previousWords = "${words[i - 2]} ${words[i - 1]}"
            val possiblePostfixes = mapForWords[previousWords] ?: break
            val random = Random()
            val randomPostfix = possiblePostfixes[random.nextInt(possiblePostfixes.size)]

            words.add(randomPostfix)
            words.forEach {print("$it ")}
            println()
        }
        return words.joinToString(" ")
    }
}