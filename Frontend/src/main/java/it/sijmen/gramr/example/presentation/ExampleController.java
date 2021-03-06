package it.sijmen.gramr.example.presentation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import it.sijmen.gramr.common.presentation.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sijmen on 2-4-2016.
 */
@Singleton
public class ExampleController extends AbstractController {

    private ExampleModel model;

    @Inject
    public ExampleController(ExampleModel model){
        this.model = model;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("data", model.getData());

        show(req, resp, "ExamplePageView");
    }
}
