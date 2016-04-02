package it.sijmen.gramr.example;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Created by Sijmen on 3-4-2016.
 */
public class MyModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("HelloWorldTxt")).toInstance("hallo wereld mensen!");
    }

}
