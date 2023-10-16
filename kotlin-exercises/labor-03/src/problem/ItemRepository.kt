package problem

import java.io.File

class ItemRepository(){
    private val items = mutableListOf<Item>()

    init{
        val lines:List<String> = File("D:\\Egyetem\\III-1 ev\\Android\\kotlin-exercises\\labor-03\\src\\problem\\questions.txt")
            .useLines { it.toList() }

        for (i in lines.indices step 6){
            val question = lines[i]

            val ans1: String = lines[i + 1]
            val ans2: String = lines[i + 2]
            val ans3: String = lines[i + 3]
            val ans4: String = lines[i + 4]
            val correct: Int = lines[i + 5].toInt()

            saveItem(Item(question, mutableListOf(ans1, ans2, ans3, ans4), correct))
        }
    }

    fun randomItem() = items.random()

    fun saveItem(item: Item): Unit{
        items.add(item)
    }

    fun size(): Int{
        return items.size
    }
}
