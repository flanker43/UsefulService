import java.io.IOException;

import static Controllers.HomePageController.getHomePage;
import static Controllers.HomePageController.postHomePage;
import static Controllers.WeatherController.getWeather;
import static spark.Spark.*;

public class Application {
    public static void main(String[] args) throws IOException {
        get("/HomePage", getHomePage);

        post("/HomePage", postHomePage);

        get("/Weather", getWeather);
    }
}

