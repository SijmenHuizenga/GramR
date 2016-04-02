package it.sijmen.gramr.example;

import com.google.inject.name.Names;
import com.google.inject.servlet.ServletModule;
import it.sijmen.gramr.example.presentation.ExamplePageController;

/**
 * Created by Sinius on 2-4-2016.
 */
public class MyServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        serve("/example/*").with(ExamplePageController.class);

        bind(String.class).annotatedWith(Names.named("HelloWorldTxt")).toInstance("hallo wereld mensen!");
    }
}
