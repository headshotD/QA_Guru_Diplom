package config;

import org.aeonbits.owner.Config;

import java.net.URL;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:key.properties",
        "classpath:local.properties",
        "classpath:remote.properties",
})

public interface WebDriverConfig extends Config {

    @Key("CreditTitle")
    String creditTitle();

    @Key("expected.calculator.title")
    String creditCalculator();

    @Key("textDebitCardAlfaOnly")
    String textDebitCardAlfaOnly();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("version")
    @DefaultValue("127.0")
    String browserVersion();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    URL getRemoteURL();
}
