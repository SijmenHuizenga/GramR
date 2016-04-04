package it.sijmen.gramr.presentation;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Created by Sijmen on 2-4-2016.
 *
 * A ServletContextListener is a Java servlet component that is triggered as soon as a web application is deployed,
 * and before any requests begin to arrive. Guice Servlet provides a convenience utility that you can subclass in
 * order to register your own ServletContextListeners
 *
 */
public class MyGuiceServletContextListener extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new GuiceInjectorModule());
    }
}
