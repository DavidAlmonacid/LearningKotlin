package collections

fun main() {

    /* Lists are similar to arrays but with additional functionalities.
     * They are immutable by default. You can use mutableListOf to create a mutable list.
     * Lists are more flexible than arrays. You can add, remove, and update elements in a list.
     * ✔️✔️✔️ 👍👍👍
     */

    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    // Size of the list
    println(solarSystem.size)

    // Accessing elements
    println(solarSystem[2])
    println(solarSystem[3])

    // Index of an element
    println(solarSystem.indexOf("Earth"))
    println(solarSystem.indexOf("Pluto"))

    // Loop over the list
    for (planet in solarSystem) {
        println(planet)
    }

    // Adding an element
    solarSystem.add("Pluto")
    solarSystem.add(3, "Theia")
    solarSystem[3] = "Future Moon"
    println(solarSystem)

    // Removing an element
    solarSystem.removeAt(9)
    solarSystem.remove("Future Moon")
    println(solarSystem)
    println(solarSystem.contains("Pluto"))
}