package Controllers;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class HomePageController {
    public static void main(String[] args) throws IOException {
        get("/hello", (req, res) -> PebbleEng.eng());
    }
}

