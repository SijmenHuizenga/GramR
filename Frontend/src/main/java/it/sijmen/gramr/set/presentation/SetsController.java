package it.sijmen.gramr.set.presentation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import it.sijmen.gramr.common.presentation.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sinius on 4-4-2016.
 */
@Singleton
public class SetsController extends AbstractController {

    @Inject
    private SetModel setModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo: dit zou nu perfect met een filter gedaan kunnen worden.
        String user = getUser(req);
        if(user == null) {
            resp.sendRedirect("/");
            return;
        }

        req.setAttribute("setList", setModel.getSetsByUser(user));
        req.setAttribute("user", user);

        show(req, resp, "SetsView");
    }
}
