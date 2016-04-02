package it.sijmen.gramr.example.presentation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sijmen on 2-4-2016.
 */
@Singleton
public class ExamplePageController extends HttpServlet {

    private String helloWorldText;

    @Inject
    public ExamplePageController(@Named("HelloWorldTxt") String helloWorldText){
        this.helloWorldText = helloWorldText;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("data", helloWorldText);

        //include ipv forward want: http://stackoverflow.com/questions/5284026/forwarding-request-to-a-jsp
        req.getRequestDispatcher("/index.jsp").include(req, resp);
    }
}
