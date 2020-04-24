package Controllers;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class WeatherController {

    public static Route getWeather = (Request request, Response response) -> {
        PebbleEngine engine = new PebbleEngine.Builder().build();
        PebbleTemplate compiledTemplate = engine.getTemplate("Weather.html");

        Map<String, Object> context = new HashMap<>();
        context.put("result", HomePageController.cityResult());

        Writer writer = new StringWriter();
        compiledTemplate.evaluate(writer, context);
        String output = writer.toString();
        return output;
    };

}
