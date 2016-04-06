package it.sijmen.gramr.test.presentation;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.presentation.model.ExampleDirectModel;
import it.sijmen.gramr.example.service.providers.ExampleDirectServiceProvider;
import it.sijmen.gramr.test.presentation.mock.MockExampleDirectServiceProvider;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 6-4-2016.
 */
public class TestExampleDirectModel {

    @Test
    public void testGetData() throws Exception {
        ExamplePojo p = new ExamplePojo(1, "A");
        Injector injector = Guice.createInjector(new MockInjectorModule(p));
        ExampleDirectModel model = injector.getInstance(ExampleDirectModel.class);

        assertEquals(p.getData(), model.getData());
    }

    class MockInjectorModule extends AbstractModule {
        private ExamplePojo thePojo;

        MockInjectorModule(ExamplePojo thePojo) {
            this.thePojo = thePojo;
        }

        @Override
        protected void configure() {
            bind(ExampleDirectServiceProvider.class).toInstance(new MockExampleDirectServiceProvider(thePojo));
        }
    }


}