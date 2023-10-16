package problem

class ItemController(private val itemService: ItemService){
    fun quiz(numberOfQuestions: Int) {
        val selectedItems = itemService.selectRandomItems(numberOfQuestions)
        var correctAnswers = 0

        if (selectedItems != null) {
            for ((index, item) in selectedItems.withIndex()) {
                println("${index + 1}. ${item.question}")
                item.answers.withIndex().forEach {
                    print("\t${it.index + 1}.) ${it.value}\t")
                }
                var userAnswer: Int? = null

                while (userAnswer !in 1..item.answers.size) {
                    print("\nYour choice: ")
                    userAnswer = readLine()?.toIntOrNull()

                    if (userAnswer !in 1..item.answers.size){
                        println("Invalid input. Please enter a number between 1 and ${item.answers.size}.")
                    }
                }

                if (userAnswer == item.correct) {
                    println("Correct!")
                    correctAnswers++
                } else {
                    println("Incorrect. The correct answer is: ${item.correct} - ${item.answers[item.correct - 1]}")
                }
            }
        }

        println("Quiz Results: $correctAnswers/$numberOfQuestions correct answers, ${(correctAnswers.toDouble() / numberOfQuestions) * 100}%")
    }
}
