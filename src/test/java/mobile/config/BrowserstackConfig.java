package mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile/browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("browserstack.user")
    @DefaultValue("olegn_JPDWZe")
    String user();

    @Key("browserstack.key")
    @DefaultValue("JRwmm3z5xpvFmF9xkj4k")
    String key();

    @Key("browserstack.url")
    String url();

    @Key("browserstack.app")
    String app();

    @Key("device.android")
    String androidDevice();

    @Key("os.android")
    String androidOsVersion();

}