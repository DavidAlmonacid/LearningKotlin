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
        ),
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
        Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)
    )
    println("\nMy Events: $myEvents")
    println(myEvents.size)

    // Filtering short events
    val myShortEvents = myEvents.filter { event -> event.durationInMinutes < 60 }
    println("\nMy Short Events: $myShortEvents")
    println("You have ${myShortEvents.size} short events.")

    // Grouping events by daypart
    val myGroupedEventsByDaypart = myEvents.groupBy { event -> event.daypart }
    println("\nMy Grouped Events By Daypart: $myGroupedEventsByDaypart")

    myGroupedEventsByDaypart.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }

    // Printing the last item
    println("\nLast event of the day: ${myEvents.last().title}")
}
