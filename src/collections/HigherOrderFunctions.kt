package collections

data class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double,
)

val cookies = listOf(
    Cookie(name = "Chocolate Chip", softBaked = false, hasFilling = false, price = 1.69),
    Cookie(name = "Banana Walnut", softBaked = true, hasFilling = false, price = 1.49),
    Cookie(name = "Vanilla Creme", softBaked = false, hasFilling = true, price = 1.59),
    Cookie(name = "Chocolate Peanut Butter", softBaked = false, hasFilling = true, price = 1.49),
    Cookie(name = "Snickerdoodle", softBaked = true, hasFilling = false, price = 1.39),
    Cookie(name = "Blueberry Tart", softBaked = true, hasFilling = true, price = 1.79),
    Cookie(name = "Sugar and Sprinkles", softBaked = false, hasFilling = false, price = 1.39),
)

fun main() {
    // Learning .forEach()
    cookies.forEach { cookie -> println("Menu Item: ${cookie.name}") }

    // Learning .map()
    val fullMenu = cookies.map { cookie ->
        "${cookie.name} - $${cookie.price}"
    }
    println("\nFull Menu:")
    fullMenu.forEach { println(it) }

    // Learning .filter()
    val softBakedMenu = cookies.filter { cookie -> cookie.softBaked }
    println("\nSoft Baked Menu:")
    softBakedMenu.forEach { println("${it.name} - $${it.price}") }

    // Learning .groupBy()
    val groupedMenu = cookies.groupBy { cookie ->
        if (cookie.softBaked) {
            "Soft Baked"
        } else {
            "Crunchy"
        }
    }
    val softBakedMenu2 = groupedMenu["Soft Baked"] ?: emptyList()
    val crunchyMenu = groupedMenu["Crunchy"] ?: emptyList()
    println("\nSoft cookies:")
    softBakedMenu2.forEach {
        println("${it.name} - $${it.price}")
    }
    println("\nCrunchy cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }
}