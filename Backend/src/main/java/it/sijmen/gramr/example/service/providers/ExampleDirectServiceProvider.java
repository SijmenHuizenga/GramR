package it.sijmen.gramr.example.service.providers;

import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.service.ExampleServiceProvider;

import java.io.IOException;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class ExampleDirectServiceProvider extends ExampleServiceProvider {

    @Override
    public ExamplePojo getData() {
        try {
            return super.getData();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
