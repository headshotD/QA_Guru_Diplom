package mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile/emulation.properties"
})
public interface EmulationConfig extends Config {

    @Key("emulation.url")
    String url();

    @Key("platformName")
    String platform();

    @Key("deviceName")
    String emulationDevice();

    @Key("platformVersion")
    String emulationOsVersion();

    @Key("appPackage")
    String emulationSetAppPackage();

    @Key("appActivity")
    String emulationSetAppActivity();

    @Key("automationName")
    String automationName();

    @Key("app")
    String appPath();

}