package problem

fun main() {
    val itemRepository = ItemRepository()
    val itemService = ItemService(itemRepository)
    val itemController = ItemController(itemService)

    itemController.quiz(5)
}