package it.sijmen.gramr.test.service;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.data.ExampleDAO;
import it.sijmen.gramr.example.service.ExampleService;
import it.sijmen.gramr.test.service.mock.MockExampleDAO;
import it.sijmen.gramr.test.service.mock.MockRandom;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Sinius on 6-4-2016.
 */
public class TestExampleService {

    @Test
    public void testGetData() throws IOException {
        Injector injector = Guice.createInjector(new MockInjectorModule());
        ExampleService service = injector.getInstance(ExampleService.class);

        assertEquals(createPojoArray().get(MockRandom.returnsAlways), service.getData());
    }

    class MockInjectorModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(ExampleDAO.class).toInstance(new MockExampleDAO(createPojoArray()));
            bind(Random.class).to(MockRandom.class);
        }
    }

    public static ArrayList<ExamplePojo> createPojoArray(){
        ArrayList<ExamplePojo> out = new ArrayList<>();
        out.add(new ExamplePojo(1, "a"));
        out.add(new ExamplePojo(2, "b"));
        return out;
    }



}
