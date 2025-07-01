package web.config;

import org.aeonbits.owner.Config;

import java.net.URL;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:key.properties",
        "classpath:resources/web/local.properties",
        "classpath:resources/web/remote.properties",
})

public interface WebDriverConfig extends Config {

    @Key("CreditTitle")
    String creditTitle();

    @Key("expected.calculator.title")
    String creditCalculator();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("version")
    @DefaultValue("127.0")
    String browserVersion();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("searchText")
    String searchText();

    @Key("remoteUrl")
    URL getRemoteURL();
}
