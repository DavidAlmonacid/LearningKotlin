package collections

fun main() {
    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    println(solarSystem)

    // Get the size of the map
    println(solarSystem.size)

    // Set the value of a key
    solarSystem["Pluto"] = 5
    println(solarSystem)
    println(solarSystem.size)

    // Get the value of a key
    println(solarSystem["Earth"])
    println(solarSystem["Theia"])

    // Remove a key
    solarSystem.remove("Pluto")
    println(solarSystem)
    println(solarSystem.size)

    // Modify the value of a key
    solarSystem["Jupiter"] = 78
    println(solarSystem["Jupiter"])
}