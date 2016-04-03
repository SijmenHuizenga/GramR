package it.sijmen.gramr.example.service;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import it.sijmen.gramr.example.MyModule;

/**
 * Created by Sijmen on 2-4-2016.
 */
public abstract class ExampleServiceProvider {

    private ExampleService dataCreator;

    @Inject
    public ExampleServiceProvider(){
        this.dataCreator = createInjector().getInstance(ExampleService.class);
    }

    protected String getData(){
        return dataCreator.getData();
    }

    protected Injector createInjector(){
        return Guice.createInjector(new MyModule());
    }

}
