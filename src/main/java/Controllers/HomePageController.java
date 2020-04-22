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

import static Controllers.LoginPageController.postLogin;

public class HomePageController {
    public static Route getHomePage = (Request request, Response response) -> {
        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream("src/main/resources/config.properties");

        property.load(fis);

        PebbleEngine engine = new PebbleEngine.Builder().build();

        PebbleTemplate compiledTemplate = engine.getTemplate("HomePage.pebble");

        String result = Weight.gToKg(456);

        Map<String, Object> context = new HashMap<>();
        context.put("result", LoginPageController.a);

        Writer writer = new StringWriter();
        compiledTemplate.evaluate(writer, context);
        String output = writer.toString();
        return output;
    };
}
