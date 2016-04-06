package it.sijmen.gramr.common.presentation;

import com.google.inject.servlet.GuiceFilter;

import javax.servlet.annotation.WebFilter;

/**
 * Created by Sijmen on 2-4-2016.
 * Alles wordt geregeld door mijn papa (GuiceFilter). Het enige dat deze klasse
 * doet is het toevoegen van de annotatie @WebFilter("*")
 */
@WebFilter("*")
public class GuiceWebFilter extends GuiceFilter {

}
