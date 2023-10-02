package problem1

fun main(args: Array<String>) {
//    val dict: IDictionary = DSAListDictionary("D:\\Egyetem\\III-1 ev\\Android\\kotlin-exercises\\labor-02\\src\\resources\\manyi_dict.txt")
    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryType.TREE_SET)
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }
}