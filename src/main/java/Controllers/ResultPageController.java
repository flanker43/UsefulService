package Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ResultPageController {

    public static Route getResultPage = (Request request, Response response) -> {
        PebbleEngine engine = new PebbleEngine.Builder().build();
        PebbleTemplate compiledTemplate = engine.getTemplate("static/ResultPage.html");
        Rest r = new Rest();
        r.getClient();

        ObjectMapper mapper = new ObjectMapper();

//        String resp = r.getResponse1();
//        CountryDto cD = mapper.readValue(resp, CountryDto.class);

//        CountryDto cD = new CountryDto();
        Map<String, Object> context = new HashMap<>();
        context.put("res", "res");

        context.put("country", r.country1);
        context.put("confirmed", r.confirmed1);
        context.put("recovered", r.recovered1);
        context.put("critical", r.critical1);
        context.put("deaths", r.deaths1);

//        context.put("country", cD.getCountry());
//        context.put("confirmed", cD.getConfirmed());
//        context.put("recovered", cD.getRecovered());
//        context.put("critical", cD.getCritical());
//        context.put("deaths", cD.getDeaths());

        Writer writer = new StringWriter();
        compiledTemplate.evaluate(writer, context);
        String output = writer.toString();
        return output;
    };

}