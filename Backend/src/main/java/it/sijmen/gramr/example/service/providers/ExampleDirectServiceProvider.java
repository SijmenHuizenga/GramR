package it.sijmen.gramr.example.service.providers;

import it.sijmen.gramr.example.service.ExampleServiceProvider;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class ExampleDirectServiceProvider extends ExampleServiceProvider {

    public String getTheData(){
        return this.getData();
    }

}
