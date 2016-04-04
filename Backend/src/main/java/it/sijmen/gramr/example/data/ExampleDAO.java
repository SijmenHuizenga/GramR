package it.sijmen.gramr.example.data;

import it.sijmen.gramr.common.pojo.ExamplePojo;

import java.io.IOException;

/**
 * Created by Sinius on 3-4-2016.
 */
public interface ExampleDAO {

    ExamplePojo getData() throws IOException;

}
