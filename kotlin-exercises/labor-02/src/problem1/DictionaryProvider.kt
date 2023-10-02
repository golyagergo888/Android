package problem1

class DictionaryProvider {
    companion object{
        fun createDictionary(type: DictionaryType): IDictionary{
            return when(type){
                DictionaryType.ARRAY_LIST -> DSAListDictionary("D:\\Egyetem\\III-1 ev\\Android\\kotlin-exercises\\labor-02\\src\\resources\\manyi_dict.txt")
                DictionaryType.TREE_SET -> DSATreeSetDictionary("D:\\Egyetem\\III-1 ev\\Android\\kotlin-exercises\\labor-02\\src\\resources\\manyi_dict.txt")
                DictionaryType.HASH_SET -> DSAHashSetDictionary("D:\\Egyetem\\III-1 ev\\Android\\kotlin-exercises\\labor-02\\src\\resources\\manyi_dict.txt")
            }
        }
    }
}