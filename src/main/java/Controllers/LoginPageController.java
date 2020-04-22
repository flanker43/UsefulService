package Controllers;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.StringWriter;
import java.io.Writer;

public class LoginPageController {
    static String login = "Artem";
    static String pass = "5555";
    static String a;

    public static Route getLogin = (Request request, Response response) -> {
        PebbleEngine engine = new PebbleEngine.Builder().build();
        PebbleTemplate compiledTemplate = engine.getTemplate("LoginPage.html");
        Writer writer = new StringWriter();
        compiledTemplate.evaluate(writer);
        String output = writer.toString();
        return output;
    };

    public static Route postLogin = (Request request, Response response) -> {
        String entryLogin = request.queryParams("login");
        String entryPass = request.queryParams("password");
        if (login == entryLogin && pass == entryPass) {
            response.redirect("/HomePage");
        }
        else {
            response.redirect("/HomePage");
        }
        a = String.join(" And ", login, pass);
        return null;
    };
}
