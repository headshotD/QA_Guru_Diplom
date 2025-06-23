package mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;

import io.appium.java_client.android.AndroidDriver;
import mobile.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserstackDriver implements WebDriverProvider {

    private static final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities caps = new DesiredCapabilities();

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", config.user());
        bstackOptions.put("accessKey", config.key());
        bstackOptions.put("projectName", "Alfa Bank");
        bstackOptions.put("buildName", "Android Build");
        bstackOptions.put("sessionName", "Mobile Tests");
        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", config.androidDevice());
        caps.setCapability("platformVersion", config.androidOsVersion());
        caps.setCapability("app", config.app());
        caps.setCapability("bstack:options", bstackOptions);

        try {
            System.out.println("Creating BrowserStack session with capabilities: " + caps);
            return new AndroidDriver(
                    new URL("https://hub.browserstack.com/wd/hub"),
                    caps
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to create BrowserStack driver", e);
        }
    }
}