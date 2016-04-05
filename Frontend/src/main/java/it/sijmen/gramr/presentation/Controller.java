package it.sijmen.gramr.presentation;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.servlet.RequestParameters;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Sijmen on 3-4-2016.
 */
public abstract class Controller extends HttpServlet {

    protected final String USER_COOKIE_KEY = "user";

    @Inject
    @RequestParameters
    protected Provider<Map<String, String[]>> reqParamsProvider;

    private String pagesFolder = "/WEB-INF/pages/";
    private String jspExtention = ".jsp";

    /**
     * Shows a JSP file. This should be the final call in the 'doGet' method.
     * @param jspName The name of he servlet to show.
     */
    protected void show(HttpServletRequest req, HttpServletResponse resp, String jspName) throws ServletException, IOException {
        //include ipv forward want: http://stackoverflow.com/questions/5284026/forwarding-request-to-a-jsp
        req.getRequestDispatcher(pagesFolder + jspName + jspExtention).include(req, resp);
    }

    protected String getParameter(String key){
        Map<String, String[]> parameters = reqParamsProvider.get();
        if(!parameters.containsKey(key))
            return null;
        String[] vals = parameters.get(key);
        if(vals.length == 0)
            return null;
        if(vals[0] == null || vals[0].isEmpty())
            return null;
        return vals[0];
    }

    private Cookie getUserCookie(HttpServletRequest req){
        for (Cookie cookie : req.getCookies()) {
            if(cookie.getName().equals(USER_COOKIE_KEY))
                return cookie;
        }
        return null;
    }

    protected String getUser(HttpServletRequest req) {
        Cookie cookie = getUserCookie(req);
        if(cookie == null)
            return null;
        return cookie.getValue();
    }

    protected void setUser(HttpServletResponse resp, String user) {
        Cookie c = new Cookie(USER_COOKIE_KEY, user);
        c.setMaxAge(60*60*24);

        resp.addCookie(c);
    }

}
