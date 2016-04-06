package it.sijmen.gramr.test.presentation.mock;

import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.service.providers.ExampleDirectServiceProvider;

/**
 * Created by Sinius on 6-4-2016.
 */
public class MockExampleDirectServiceProvider extends ExampleDirectServiceProvider {

    public ExamplePojo thePojoToReturn;

    public MockExampleDirectServiceProvider(ExamplePojo thePojoToReturn) {
        this.thePojoToReturn = thePojoToReturn;
    }

    @Override
    public ExamplePojo getData() {
        return thePojoToReturn;
    }
}
