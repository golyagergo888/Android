package extra

fun main() {
    // ex 1: Grouping anagrams from a list of strings
    val anagrams1 = groupAnagrams(listOf("eat", "tea", "tan", "ate", "nat", "bat").toTypedArray())
    println("ex 1:")
    printAnagramGroups(anagrams1)

    // ex 2: Grouping anagrams with mixed case
    val anagrams2 = groupAnagrams(listOf("eat", "tEa", "Tan", "atE", "NAT", "bat").toTypedArray())
    println("\nex 2:")
    printAnagramGroups(anagrams2)

    // ex 3: Only one group, no anagrams
    val anagrams3 = groupAnagrams(listOf("eat").toTypedArray())
    println("\nex 3:")
    printAnagramGroups(anagrams3)

    // ex 4: Empty list, no groups
    val anagrams4 = groupAnagrams(emptyList<String>().toTypedArray())
    println("\nex 4:")
    printAnagramGroups(anagrams4)
}

fun printAnagramGroups(anagramGroups: List<List<String>>) {
    for ((index, group) in anagramGroups.withIndex()) {
        println("Group $index:")
        group.forEach { println(it) }
    }
}
