package it.sijmen.gramr.example.presentation.model;

import it.sijmen.gramr.example.presentation.ExampleModel;
import it.sijmen.gramr.example.service.adaptee.ExampleDirectService;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class ExampleDirectModel implements ExampleModel {

    private ExampleDirectService exampleService;

    public ExampleDirectModel(){
        this.exampleService = new ExampleDirectService();
    }

    public String getData(){
        return this.exampleService.getTheData();
    }

}
