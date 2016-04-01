package it.sijmen;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Hello world!
 *
 */
@WebServlet("/MyApp/*")
public class HomePageController extends HttpServlet {

     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("data", "Hello Getter!");

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("data", "Hello poster!");

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
