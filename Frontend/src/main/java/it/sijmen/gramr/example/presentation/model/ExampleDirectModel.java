package it.sijmen.gramr.example.presentation.model;

import it.sijmen.gramr.common.presentation.AbstractModel;
import it.sijmen.gramr.example.presentation.ExampleModel;
import it.sijmen.gramr.example.service.providers.ExampleDirectServiceProvider;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class ExampleDirectModel extends AbstractModel implements ExampleModel {

    private ExampleDirectServiceProvider exampleService;

    public ExampleDirectModel(){
        this.exampleService = new ExampleDirectServiceProvider();
    }

    public String getData(){
        return this.exampleService.getData().getData();
    }

}
