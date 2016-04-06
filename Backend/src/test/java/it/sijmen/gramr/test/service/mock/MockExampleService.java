package it.sijmen.gramr.test.service.mock;

import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.service.ExampleService;

import java.io.IOException;

/**
 * Created by Sinius on 6-4-2016.
 */
public class MockExampleService extends ExampleService{

    private ExamplePojo whatToReturn;

    public MockExampleService(ExamplePojo whatToReturn) {
        super(null, null);
        this.whatToReturn = whatToReturn;
    }

    public ExamplePojo getData() throws IOException {
        return whatToReturn;
    }

}
