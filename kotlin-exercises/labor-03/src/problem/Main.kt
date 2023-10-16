package problem

fun main() {
    val itemRepository = ItemRepository()
    val itemService = ItemService(itemRepository)
    val itemController = ItemController(itemService)

    print("How many questions do you want? ")
    val numberOfQuestions = readLine()?.toIntOrNull()

    if (numberOfQuestions != null) {
        itemController.quiz(numberOfQuestions)
    }
}
