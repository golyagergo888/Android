package problem

import java.util.Random

data class Item(val question: String, val answers: List<String>, val correct: Int){

}

class ItemRepository(){
    private val items = mutableListOf<Item>(
        Item("What is the capital of France?", listOf("London", "Berlin", "Paris", "Madrid"), 3),
        Item("What is the capital of Hungary?", listOf("London", "Berlin", "Paris", "Madrid", "Budapest"), 4),
        Item("How many continents are there?", listOf("5", "6", "7", "8"), 3),
        Item("What is the capital of Romania?", listOf("Bucharest", "Berlin", "Paris", "Madrid"), 1),
        Item("How many continents are there?", listOf("5", "6", "7", "8"), 3),
        Item("Which planet is known as the Red Planet?", listOf("Venus", "Mars", "Jupiter", "Saturn"), 2),
        Item("What is the largest mammal on Earth?", listOf("Elephant", "Giraffe", "Blue Whale", "Lion"), 3),
        Item("Who wrote 'Romeo and Juliet'?", listOf("Charles Dickens", "William Shakespeare", "Jane Austen", "Mark Twain"), 2)
    )

    fun randomItem(): Item{
        val randomIndex = (0 .. items.size).random()
        println("$randomIndex. question")
        return items[randomIndex]
    }

    fun saveItem(item: Item): Unit{
        items.add(item)
    }

    fun size(): Int{
        return items.size
    }
}

class ItemService(private val itemRepository: ItemRepository){
    fun selectRandomItems(count: Int): List<Item> {
        val randomItems = mutableListOf<Item>()

        repeat(count) {
            val randomItem = itemRepository.randomItem()
            randomItems.add(randomItem)
        }

        return randomItems
    }
}

class ItemController(private val itemService: ItemService){
    fun quiz(numberOfQuestions: Int) {
        val selectedItems = itemService.selectRandomItems(numberOfQuestions)
        var correctAnswers = 0

        for (item in selectedItems) {
            println(item.question)
            for ((index, answer) in item.answers.withIndex()) {
                println("${index + 1}. $answer")
            }
            print("Your choice: ")
            val userAnswer = readLine()?.toIntOrNull()

            if (userAnswer == item.correct) {
                println("Correct!")
                correctAnswers++
            } else {
                println("Incorrect. The correct answer is: ${item.answers[item.correct - 1]}")
            }
        }

        println("Quiz Results: $correctAnswers/$numberOfQuestions correct answers")
    }
}
