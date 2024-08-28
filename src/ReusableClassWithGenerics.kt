interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty,
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}

class Quiz : ProgressPrintable {
    val question1 = Question("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total = 10
        var answered = 3
    }

    override val progressText: String
        get() = "$answered of $total answered."

    override fun printProgressBar() {
        repeat(answered) { print("▓") }
        repeat(total -  answered) { print("▒") }
        println()
        println(progressText)
    }
}

fun main() {
    println(Quiz().printProgressBar())
}