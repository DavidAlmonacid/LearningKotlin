/*
9. Task 4
Your manager likes how the app is coming along, but decides the user should be able to see a summary of their short events,
based on the event's duration. For example, "You have 5 short events."

A "short" event is an event that is less than 60 minutes.

Using the events variable code from the previous task's solution, how would you achieve this result?

Note: It might help to solve this problem in multiple steps. How would you filter the events based on their duration?
Once you filter the desired events, how do you determine the quantity?

Click Next to continue onto our solution.
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

    val myShortEvents = myEvents.filter { event -> event.durationInMinutes < 60 }
    println("\nMy Short Events: $myShortEvents")
    println("You have ${myShortEvents.size} short events.")
}
