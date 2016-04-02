package it.sijmen.gramr.example.presentation.model;

import it.sijmen.gramr.example.presentation.ExamplePageModel;
import it.sijmen.gramr.example.service.adaptee.ExampleDirectService;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class ExamplePageDirectModel implements ExamplePageModel {

    private ExampleDirectService exampleService;

    public ExamplePageDirectModel(){
        this.exampleService = new ExampleDirectService();
    }

    public String getData(){
        return this.exampleService.getTheData();
    }

}
