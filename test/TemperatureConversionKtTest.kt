import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class TemperatureConversionKtTest {

    @Test
    fun celsiusToFahrenheit() {
        assertEquals(80.6, celsiusToFahrenheit(27.0))
    }

    @Test
    fun kelvinToCelsius() {
        assertEquals(76.85, kelvinToCelsius(350.0), 0.01)
    }

    @Test
    fun fahrenheitToKelvin() {
        assertEquals(260.93, fahrenheitToKelvin(10.0), 0.01)
    }
}