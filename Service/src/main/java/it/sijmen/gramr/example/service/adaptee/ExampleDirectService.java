package it.sijmen.gramr.example.service.adaptee;

import it.sijmen.gramr.example.service.ExampleService;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class ExampleDirectService extends ExampleService {

    public String getTheData(){
        return this.getData();
    }

}
