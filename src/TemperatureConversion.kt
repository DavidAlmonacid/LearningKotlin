/**
 * In the initial code provided in the following code snippet,
 * write a program that converts a temperature from one scale to another with these formulas:
 * - Celsius to Fahrenheit: ° F = 9/5 (° C) + 32
 * - Kelvin to Celsius: ° C = K - 273.15
 * - Fahrenheit to Kelvin: K = 5/9 (° F - 32) + 273.15
 *
 * Complete the main() function so that it calls the printFinalTemperature() function and prints the following lines.
 * - 27.0 degrees Celsius is 80.60 degrees Fahrenheit.
 * - 350.0 degrees Kelvin is 76.85 degrees Celsius.
 * - 10.0 degrees Fahrenheit is 260.93 degrees Kelvin.
 *
 * You need to pass arguments for the temperature and conversion formula.
 *
 * Hint: you may want to use Double values to avoid Integer truncation during division operations.
 *
 * Note that the String.format("%.2f", /* measurement */ ) method is used to convert
 * a number into a String type with 2 decimal places.
 */

fun main() {
    printFinalTemperature(
        initialUnit = "Celsius",
        finalUnit = "Fahrenheit",
        initialMeasurement = 27.0,
        conversionFormula = { celsiusToFahrenheit(it) }
    )

    printFinalTemperature(
        initialUnit = "Kelvin",
        finalUnit = "Celsius",
        initialMeasurement = 350.0,
        conversionFormula = { kelvinToCelsius(it) }
    )

    printFinalTemperature(
        initialUnit = "Fahrenheit",
        finalUnit = "Kelvin",
        initialMeasurement = 10.0,
        conversionFormula = { fahrenheitToKelvin(it) }
    )

    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }
    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }
}

fun celsiusToFahrenheit(temp: Double): Double {
    return (9.0 / 5.0 * temp) + 32
}

fun kelvinToCelsius(temp: Double): Double {
    return temp - 273.15
}

fun fahrenheitToKelvin(temp: Double): Double {
    return 5.0 / 9.0 * (temp - 32) + 273.15
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
