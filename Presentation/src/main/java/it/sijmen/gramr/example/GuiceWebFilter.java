package it.sijmen.gramr.example;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by Sijmen on 2-4-2016.
 */
@WebFilter("/*")
public class GuiceWebFilter extends GuiceFilter {

    //Alles wordt geregeld door mijn papa (GuiceFilter). Het einge dat ik toevoeg
    //is de @WebFilter annotatie waarin ik aangeef op welke url's ik van toepassing
    //ben.

}
