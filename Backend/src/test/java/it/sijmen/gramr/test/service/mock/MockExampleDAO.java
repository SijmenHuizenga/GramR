package it.sijmen.gramr.test.service.mock;

import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.data.ExampleDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Sinius on 6-4-2016.
 */
public class MockExampleDAO implements ExampleDAO {

    public ArrayList<ExamplePojo> toReturn;

    public MockExampleDAO(ArrayList<ExamplePojo> toReturn) {
        this.toReturn = toReturn;
    }

    @Override
    public ArrayList<ExamplePojo> getAllPojos() throws IOException {
        return toReturn;
    }
}