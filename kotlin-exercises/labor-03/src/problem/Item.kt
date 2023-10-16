package problem

import java.io.File
import java.util.Random

data class Item(
    val question: String,
    val answers: MutableList<String>,
    val correct: Int){}
