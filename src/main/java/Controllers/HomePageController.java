package Controllers;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.StringWriter;
import java.io.Writer;


public class HomePageController {
    static String cityResult;
    public static Route getHomePage = (Request request, Response response) -> {
        PebbleEngine engine = new PebbleEngine.Builder().build();
        PebbleTemplate compiledTemplate = engine.getTemplate("HomePage.pebble");
        Writer writer = new StringWriter();
        compiledTemplate.evaluate(writer);
        String output = writer.toString();
        return output;
    };

    public static Route postHomePage = (Request request, Response response) -> {
        String entryCity = request.queryParams("something");
        cityResult = entryCity;
        response.redirect("/Weather");
        return null;
    };

    public static String cityResult() {
        return cityResult;
    }

}
