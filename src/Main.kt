import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice(val name: String, val category: String) {
    open val deviceType = "unknown"
    var deviceStatus = "online"
        protected set

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++

        println("Speaker volume increased to $speakerVolume.")
    }

    fun decreaseSpeakerVolume() {
        speakerVolume--

        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++

        println("Channel number increased to $channelNumber.")
    }

    fun previousChannel() {
        channelNumber--

        println("Channel number decreased to $channelNumber.")
    }

    override fun turnOn() {
        super.turnOn()

        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to $channelNumber.")
    }

    override fun turnOff() {
        super.turnOff()

        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++

        println("Brightness increased to $brightnessLevel.")
    }

    fun decreaseBrightness() {
        brightnessLevel--

        println("Brightness decreased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2

        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0

        println("Smart Light turned off")
    }
}

class SmartHome(private val smartTvDevice: SmartTvDevice, private val smartLightDevice: SmartLightDevice) {
    var deviceTurnOnCount = 0
        private set

    private fun isDeviceTurnedOn(device: SmartDevice): Boolean {
        return device.deviceStatus == "on"
    }

    private fun turnOnDevice(device: SmartDevice) {
        if (!isDeviceTurnedOn(device)) {
            device.turnOn()
            deviceTurnOnCount++
        }
    }

    private fun turnOffDevice(device: SmartDevice) {
        if (isDeviceTurnedOn(device)) {
            device.turnOff()
            deviceTurnOnCount--
        }
    }

    // Smart TV functions
    fun turnOnTv() {
        turnOnDevice(smartTvDevice)
    }

    fun turnOffTv() {
        turnOffDevice(smartTvDevice)
    }

    fun increaseTvVolume() {
        if(isDeviceTurnedOn(smartTvDevice)) {
            smartTvDevice.increaseSpeakerVolume()
        }
    }

    fun decreaseTvVolume() {
        if(isDeviceTurnedOn(smartTvDevice)) {
            smartTvDevice.decreaseSpeakerVolume()
        }
    }

    fun changeTvChannelToNext() {
        if (isDeviceTurnedOn(smartTvDevice)) {
            smartTvDevice.nextChannel()
        }
    }

    fun changeTvChannelToPrevious() {
        if (isDeviceTurnedOn(smartTvDevice)) {
            smartTvDevice.previousChannel()
        }
    }

    fun printSmartTvInfo() {
        if (isDeviceTurnedOn(smartTvDevice)) {
            smartTvDevice.printDeviceInfo()
        }
    }

    // Smart Light functions
    fun turnOnLight() {
        turnOnDevice(smartLightDevice)
    }

    fun turnOffLight() {
        turnOffDevice(smartLightDevice)
    }

    fun increaseLightBrightness() {
        if(isDeviceTurnedOn(smartLightDevice)) {
            smartLightDevice.increaseBrightness()
        }
    }

    fun decreaseLightBrightness() {
        if(isDeviceTurnedOn(smartLightDevice)) {
            smartLightDevice.decreaseBrightness()
        }
    }

    fun printSmartLightInfo() {
        if (isDeviceTurnedOn(smartLightDevice)) {
            smartLightDevice.printDeviceInfo()
        }
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(initialValue: Int, private val minValue: Int, private val maxValue: Int) :
    ReadWriteProperty<Any?, Int> {
    private var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    val smartTvDevice = SmartTvDevice("Android TV", "Entertainment")
    val smartLightDevice = SmartLightDevice("Google Light", "Utility")
    val smartHome = SmartHome(smartTvDevice, smartLightDevice)

    smartHome.turnOnTv()
    smartHome.printSmartTvInfo()
    smartHome.increaseTvVolume()
    smartHome.increaseTvVolume()
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToPrevious()
    smartHome.changeTvChannelToPrevious()
    smartHome.changeTvChannelToPrevious()
    println()

    smartHome.turnOnLight()
    smartHome.printSmartLightInfo()
    smartHome.increaseLightBrightness()
    smartHome.increaseLightBrightness()
    smartHome.decreaseLightBrightness()
    smartHome.decreaseLightBrightness()
    smartHome.decreaseLightBrightness()
    smartHome.decreaseLightBrightness()
    smartHome.decreaseLightBrightness()
    println()

    smartHome.turnOffAllDevices()
}
