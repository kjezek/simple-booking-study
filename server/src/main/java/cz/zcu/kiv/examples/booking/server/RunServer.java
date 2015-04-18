package cz.zcu.kiv.examples.booking.server;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import cz.zcu.kiv.examples.booking.preferences.RatingLoader;
import cz.zcu.kiv.examples.booking.server.service.HotelsService;
import cz.zcu.kiv.examples.booking.server.service.RoomService;
import org.apache.commons.io.IOUtils;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerRoute;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

        get(new Route("/jquery.js") {
            @Override
            public Object handle(Request request, Response response) {
                try {
                    return IOUtils.toString(getClass().getResourceAsStream("/jquery-1.10.1.min.js"));
                } catch (IOException e) {
                    return null;
                }
            }
        });

        get(new Route("/img/*") {
            @Override
            public Object handle(Request request, Response response) {
                try {
                    String path = request.pathInfo();
                    InputStream inputStream = getClass().getResourceAsStream(path);
                    OutputStream outputStream = response.raw().getOutputStream();
                    IOUtils.copy(inputStream, outputStream);
                    response.status(HttpServletResponse.SC_OK);
                    response.header("Content-Type", "image/png");
                    return "ok";
                } catch (IOException e) {
                    return null;
                }
            }
        });
    }
}
