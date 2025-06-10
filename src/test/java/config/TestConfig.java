package config;

import org.aeonbits.owner.Config;

public class TestConfig {
    @Config.Sources({
            "classpath:test.properties"
    })
    public interface EmulationConfig extends Config {
        @Key("CreditTitle")
        String creditTitle();
    }
}
