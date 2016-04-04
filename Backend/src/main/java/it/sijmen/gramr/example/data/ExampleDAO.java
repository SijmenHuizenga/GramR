package it.sijmen.gramr.example.data;

import it.sijmen.gramr.common.pojo.ExamplePojo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Sijmen on 3-4-2016.
 */
public interface ExampleDAO {

    ArrayList<ExamplePojo> getAllPojos() throws IOException;

}
