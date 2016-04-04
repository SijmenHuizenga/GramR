package it.sijmen.gramr.presentation;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Sijmen on 2-4-2016.
 * Alles wordt geregeld door mijn papa (GuiceFilter). Het enige dat deze klasse
 * doet is het toevoegen van de annotatie @WebFilter("*")
 */
@WebFilter("*")
public class GuiceWebFilter extends GuiceFilter {

}
