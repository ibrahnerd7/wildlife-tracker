import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
            model.put("healthy", Constants.HEALTHY);
            model.put("ill", Constants.ILL);
            model.put("okay", Constants.OKAY);

            model.put("newborn", Constants.NEWBORN);
            model.put("young", Constants.YOUNG);
            model.put("adult", Constants.ADULT);


            return new ModelAndView(model, "animal-add-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightingList = Sighting.all();
            for (Sighting sightingItem : sightingList) {
                Date date = sightingItem.getSightingTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, MMMM d 'at' hh:mm a");
                simpleDateFormat.format(date);
            }
            model.put("sightings", sightingList);
            return new ModelAndView(model, "sightings-all.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sightings/add", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String age = request.queryParams("age");
            String health = request.queryParams("health");
            String andangeredName = request.queryParams("wildlifeName");
            String animalName = request.queryParams("animalName");

            String zone = request.queryParams("location");
            String endageredRangerName = request.queryParams("rangerName");
            String animalRangerName = request.queryParams("animalRangerName");

            String timeString = request.queryParams("time");

            //if age and health is null create an Animal object
            if (age == null) {
                Animal animal = new Animal(animalName);
                animal.save();
                int wildlifeId = animal.getId();
                Timestamp time = new Timestamp(new Date().getTime());
                Sighting sighting = new Sighting(wildlifeId, zone, animalRangerName, time);
                sighting.save();
            } else {
                Endagered endagered = new Endagered(age, health, andangeredName);
                int wildlifeId = endagered.getId();
                endagered.save();
                Timestamp time = new Timestamp(new Date().getTime());
                Sighting sighting = new Sighting(wildlifeId, zone, endageredRangerName, time);
                sighting.save();
            }


            response.redirect("/");

            return null;
        }, new HandlebarsTemplateEngine());


    }
}
