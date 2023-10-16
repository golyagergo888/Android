package problem

class ItemService(private val itemRepository: ItemRepository){
    fun selectRandomItems(count: Int): List<Item>? {
        if(count > itemRepository.size()) {
            throw IllegalArgumentException("Count cannot be greater than ${itemRepository.size()}")
        }

        val randomItems = mutableListOf<Item>()

        while (randomItems.size < count) {
            val item = itemRepository.randomItem()
            if(!randomItems.contains(item))
                randomItems.add(item)
        }

        return randomItems
    }
}
