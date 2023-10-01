package extra

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AnagramsGrouperTest {
    @Test
    fun threeGroupsAllLowerCase() {
        val anagrams = groupAnagrams(listOf("eat", "tea", "tan", "ate", "nat",
            "bat").toTypedArray())
        assertEquals(3, anagrams.size)
        assertTrue(anagrams.contains(listOf("eat", "tea", "ate")))
        assertTrue(anagrams.contains(listOf("tan", "nat")))
        assertTrue(anagrams.contains(listOf("bat")))
    }
    @Test
    fun threeGroupsSomeUpperCase() {
        val anagrams = groupAnagrams(listOf("eat", "tEa", "Tan", "atE", "NAT",
            "bat").toTypedArray())
        assertEquals(3, anagrams.size)
        assertTrue(anagrams.contains(listOf("eat", "tea", "ate")))
        assertTrue(anagrams.contains(listOf("tan", "nat")))
        assertTrue(anagrams.contains(listOf("bat")))
    }
    @Test
    fun validOneGroup() {
        val anagrams = groupAnagrams(listOf("eat").toTypedArray())
        assertEquals(1, anagrams.size)
        assertTrue(anagrams.contains(listOf("eat")))
    }

    @Test
    fun noGroup() {
        val anagrams = groupAnagrams(emptyList<String>().toTypedArray())
        assertEquals(0, anagrams.size)
    }
}

fun groupAnagrams(strings: Array<String>): List<List<String>> {
    val anagramGroups = mutableMapOf<String, MutableList<String>>()

    for (str in strings) {
        val sortedStr = str.toCharArray().sorted().joinToString("")
        if (!anagramGroups.containsKey(sortedStr)) {
            anagramGroups[sortedStr] = mutableListOf()
        }
        anagramGroups[sortedStr]?.add(str)
    }

    return anagramGroups.values.toList()
}
