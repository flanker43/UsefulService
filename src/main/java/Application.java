import java.io.IOException;

import static Controllers.HomePageController.getHomePage;
import static Controllers.HomePageController.postHomePage;
import static Controllers.ResultPageController.getResultPage;
import static spark.Spark.*;

public class Application {
    public static void main(String[] args) throws IOException {
        staticFiles.location("/static");

        get("/HomePage", getHomePage);

        post("/HomePage", postHomePage);

        get("/ResultPage", getResultPage);
    }
}

