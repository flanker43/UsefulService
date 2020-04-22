import Controllers.LoginPageController;

import java.io.IOException;

import static Controllers.HomePageController.getHomePage;
import static Controllers.LoginPageController.getLogin;
import static Controllers.LoginPageController.postLogin;
import static spark.Spark.*;

public class Application {
    public static void main(String[] args) throws IOException {
        get("/HomePage", getHomePage);

        get("/LoginPage", getLogin);

        post("/LoginPage", postLogin);

    }
}

