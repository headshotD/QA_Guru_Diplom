package helpers;


import mobile.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;


public class Browserstack {

    private static final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("olegn_4osMUt", "5cWCPNSQgz4oq7qSkwCi")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}