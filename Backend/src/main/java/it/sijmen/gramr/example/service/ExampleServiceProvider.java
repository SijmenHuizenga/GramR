package it.sijmen.gramr.example.service;

import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.common.service.AbstractServiceProvider;

import java.io.IOException;

/**
 * Created by Sijmen on 2-4-2016.
 */
public abstract class ExampleServiceProvider extends AbstractServiceProvider<ExampleService>{

    protected ExampleService theService;

    public ExampleServiceProvider() {
        this.theService = createInjector().getInstance(ExampleService.class);
    }

    protected ExamplePojo getData() throws IOException {
        return theService.getData();
    }
    

}
