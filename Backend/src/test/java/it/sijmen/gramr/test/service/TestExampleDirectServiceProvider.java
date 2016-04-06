package it.sijmen.gramr.test.service;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.service.ExampleService;
import it.sijmen.gramr.example.service.providers.ExampleDirectServiceProvider;
import it.sijmen.gramr.test.service.mock.MockExampleService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 6-4-2016.
 */
public class TestExampleDirectServiceProvider {

    @Test
    public void testGetDataNull(){
        Injector injector = Guice.createInjector(new MockGuiceModule(null));
        ExampleDirectServiceProvider provider = injector.getInstance(ExampleDirectServiceProvider.class);
        assertEquals(null, provider.getData());
    }

    @Test
    public void testGetData(){
        ExamplePojo pojo = new ExamplePojo(10, "hjaaai");
        Injector injector = Guice.createInjector(new MockGuiceModule(pojo));
        ExampleDirectServiceProvider provider = injector.getInstance(ExampleDirectServiceProvider.class);
        assertEquals(pojo, provider.getData());
    }

    class MockGuiceModule extends AbstractModule {

        private ExamplePojo data;

        public MockGuiceModule(ExamplePojo data) {
            this.data = data;
        }

        @Override
        protected void configure() {
            bind(ExampleService.class).toInstance(new MockExampleService(data));
        }

    }

}
