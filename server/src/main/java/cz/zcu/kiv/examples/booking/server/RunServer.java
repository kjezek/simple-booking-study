package cz.zcu.kiv.examples.booking.server;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import cz.zcu.kiv.examples.booking.preferences.RatingLoader;
import cz.zcu.kiv.examples.booking.server.service.HotelsService;
import cz.zcu.kiv.examples.booking.server.service.RoomService;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerRoute;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;


/**
 * Kamil Jezek [kjezek@kiv.zcu.cz]
 */
public class RunServer {


    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new Application());
        final HotelsService hotelsService = injector.getInstance(HotelsService.class);
        final RoomService roomService = injector.getInstance(RoomService.class);

        // main handlers
        get(new FreeMarkerRoute("/index.html") {

            @Override
            public Object handle(Request request, Response response) {

                Map<String, Object> model = new HashMap<>();
                model.put("hotels", hotelsService.loadAll());

                return modelAndView(model, "index.ftl");
            }
        });

        // ajax handlers
        get(new Route("/rating") {
            @Override
            public Object handle(Request request, Response response) {

                RatingLoader rating = new RatingLoader();
                try {
                    return new Gson().toJson(rating.load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        get(new Route("/rooms/:id") {
            @Override
            public Object handle(Request request, Response response) {
                Integer id = Integer.parseInt(request.params("id"));
                return new Gson().toJson(roomService.getRooms(id));
            }
        });
    }
}
