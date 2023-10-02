package problem1

import java.io.File
import java.util.TreeSet

class DSATreeSetDictionary(fileName: String): IDictionary {
    private var words = TreeSet<String>()

    init {
//        File(fileName).forEachLine { add(it)}
        File(IDictionary.DICTIONARY_NAME).forEachLine { add(it)}
    }

    override fun add(word: String): Boolean {
        return words.add(word)
    }

    override fun find(word: String): Boolean {
        return words.contains(word)
    }

    override fun size(): Int {
        return words.size
    }
}