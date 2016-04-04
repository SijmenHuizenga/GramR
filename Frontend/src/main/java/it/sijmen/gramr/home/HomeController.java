package it.sijmen.gramr.home;

import com.google.inject.Singleton;
import it.sijmen.gramr.presentation.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Sinius on 4-4-2016.
 */
@Singleton
public class HomeController extends Controller {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = getUser(req);

        Map<String, String[]> parameters = reqParamsProvider.get();
        if(parameters.containsKey("user")) {
            user = parameters.get("user")[0];
            setUser(resp, user);
        }

        if(user != null)
            req.setAttribute("user", user);

        show(req, resp, "HomeView");
    }


}
