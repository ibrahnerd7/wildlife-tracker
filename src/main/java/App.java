import interfaces.Wildlife;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings/add", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "sightings-add-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "sightings-all.hbs");
        }, new HandlebarsTemplateEngine());

//        post("/sightings/add", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            String wildLifeName = request.queryParams("wildlifeName");
//            Wildlife wildlife = (Wildlife) Wildlife.findByName(wildLifeName);
//            int wildlifeId = wildlife.getId();
//            String zone = request.queryParams("location");
//            String rangerName = request.queryParams("rangerName");
//            String timeString = request.queryParams("time");
//            Timestamp time = new Timestamp(new Date(timeString).getTime());
//
//            Sighting sighting = new Sighting(wildlifeId, zone, rangerName, time);
//            sighting.save();
//
//            response.redirect("/");
//
//        })


    }
}
