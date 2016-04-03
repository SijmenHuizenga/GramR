package it.sijmen.gramr.example.service;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import it.sijmen.gramr.example.MyModule;
import it.sijmen.gramr.example.domain.ExampleDataCreator;

/**
 * Created by Sijmen on 2-4-2016.
 */
public abstract class ExampleService {

    private ExampleDataCreator dataCreator;

    @Inject
    public ExampleService(){
        this.dataCreator = createInjector().getInstance(ExampleDataCreator.class);
    }

    protected String getData(){
        return dataCreator.getData();
    }

    protected Injector createInjector(){
        return Guice.createInjector(new MyModule());
    }

}
