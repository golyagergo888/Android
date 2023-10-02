package problem1

interface IDictionary {
    fun add(word: String): Boolean
    fun find(word: String): Boolean
    fun size(): Int

    companion object{
        const val DICTIONARY_NAME = "D:\\Egyetem\\III-1 ev\\Android\\kotlin-exercises\\labor-02\\src\\resources\\manyi_dict.txt"
    }
}