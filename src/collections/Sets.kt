package collections

fun main() {
    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Mercury")
    println(solarSystem)
    println(solarSystem.size)

    // Adding an element
    solarSystem.add("Pluto")
    solarSystem.add("Pluto")
    println(solarSystem)
    println(solarSystem.size)

    // Check if an element exists
    println(solarSystem.contains("Pluto"))
    println("Pluto" in solarSystem)

    // Removing an element
    solarSystem.remove("Pluto")
    println(solarSystem)
    println(solarSystem.size)
    println("Pluto" in solarSystem)
}