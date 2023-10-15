package extra

fun main(){
    /// 1
    val generator = TextGenerator()
    val inputText = "Now is not the time for sleep, now is the time for party!"
    generator.learnWords(inputText)

    val prefix = "Now is"
    generator.generateText(prefix, 20)

    /// 2
    println()
    val generator2 = TextGenerator()
    val inputText2 = "Most elmegyek pihenni mert hideg van, most elmegyek pihenni mert hideg lett."
    generator2.learnWords(inputText2)

    val prefix2 = "Most elmegyek"
    generator2.generateText(prefix2, 30)
}