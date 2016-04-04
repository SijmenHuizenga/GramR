package it.sijmen.gramr.example.model;

import it.sijmen.gramr.example.ExampleModel;
import it.sijmen.gramr.example.service.providers.ExampleDirectServiceProvider;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class ExampleDirectModel implements ExampleModel {

    private ExampleDirectServiceProvider exampleService;

    public ExampleDirectModel(){
        this.exampleService = new ExampleDirectServiceProvider();
    }

    public String getData(){
        return this.exampleService.getData().getData();
    }

}
