/*
 */

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: DayPart,
    val durationInMinutes: Int,
)

enum class DayPart {
    MORNING, AFTERNOON, EVENING
}

fun main() {
    val myEvent = Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = DayPart.EVENING,
        durationInMinutes = 15,
    )
    println(myEvent)
}