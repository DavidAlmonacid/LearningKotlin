import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SmartHomeTest {
    private lateinit var smartTvDevice: SmartTvDevice
    private lateinit var smartLightDevice: SmartLightDevice
    private lateinit var smartHome: SmartHome

    @BeforeEach
    fun setUp() {
        smartTvDevice = SmartTvDevice("Android TV", "Entertainment")
        smartLightDevice = SmartLightDevice("Google Light", "Utility")
        smartHome = SmartHome(smartTvDevice, smartLightDevice)
    }

    @Test
    fun testTurnOnTvIncreasesDeviceTurnOnCount() {
        smartHome.turnOnTv()
        assertEquals(1, smartHome.deviceTurnOnCount)
    }

    @Test
    fun testTurnOffTvDecreasesDeviceTurnOnCount() {
        smartHome.turnOnTv()
        smartHome.turnOffTv()
        assertEquals(0, smartHome.deviceTurnOnCount)
    }

    @Test
    fun testTurnOnLightIncreasesDeviceTurnOnCount() {
        smartHome.turnOnLight()
        assertEquals(1, smartHome.deviceTurnOnCount)
    }

    @Test
    fun testTurnOffLightDecreasesDeviceTurnOnCount() {
        smartHome.turnOnLight()
        smartHome.turnOffLight()
        assertEquals(0, smartHome.deviceTurnOnCount)
    }

    @Test
    fun testTurnOnMultipleDevices() {
        smartHome.turnOnTv()
        smartHome.turnOnLight()
        assertEquals(2, smartHome.deviceTurnOnCount)
    }

    @Test
    fun testTurnOffAllDevices() {
        smartHome.turnOnTv()
        smartHome.turnOnLight()
        smartHome.turnOffAllDevices()
        assertEquals(0, smartHome.deviceTurnOnCount)
    }
}