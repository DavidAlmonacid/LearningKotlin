/*
 */

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)

enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

fun main() {
    val myEvents = mutableListOf(
        Event(
            title = "Study Kotlin",
            description = "Commit to studying Kotlin at least 15 minutes per day.",
            daypart = Daypart.EVENING,
            durationInMinutes = 15,
        )
    )

    myEvents.add(
        Event(
            title = "Wake up",
            description = "Time to get up",
            daypart = Daypart.MORNING,
            durationInMinutes = 0,
        )
    )

    println(myEvents)
    println(myEvents.size)
}
