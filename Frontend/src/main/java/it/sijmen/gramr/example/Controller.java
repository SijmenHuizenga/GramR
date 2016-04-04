package it.sijmen.gramr.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sijmen on 3-4-2016.
 */
public abstract class Controller extends HttpServlet {

    private String pagesFolder = "/WEB-INF/pages/";
    private String jspExtention = ".jsp";

    /**
     * Shows a JSP file. This should be the final call in the 'doGet' method.
     * @param jspName The name of he servlet to show.
     */
    public void show(HttpServletRequest req, HttpServletResponse resp, String jspName) throws ServletException, IOException {
        //include ipv forward want: http://stackoverflow.com/questions/5284026/forwarding-request-to-a-jsp
        req.getRequestDispatcher(pagesFolder + jspName + jspExtention).include(req, resp);
    }

}
