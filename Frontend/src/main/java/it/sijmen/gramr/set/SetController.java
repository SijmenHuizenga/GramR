package it.sijmen.gramr.set;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import it.sijmen.gramr.common.pojo.Photo;
import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.presentation.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Sinius on 4-4-2016.
 */
@Singleton
public class SetController extends Controller {

    @Inject
    private SetModel setModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameters = reqParamsProvider.get();

        String user = getUser(req);
        if(user == null)
            resp.sendRedirect("/");

        req.setAttribute("setList", setModel.getSetsByUser(user));
        req.setAttribute("user", user);

        show(req, resp, "SetsView");
    }
}
