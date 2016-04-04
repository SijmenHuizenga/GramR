package it.sijmen.gramr.common.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import it.sijmen.gramr.common.GuiceInjectorModule;
import it.sijmen.gramr.example.service.ExampleService;

/**
 * Created by Sijmen on 4-4-2016.
 */
public abstract class AbstractServiceProvider<T extends AbstractService> {





    protected Injector createInjector(){
        return Guice.createInjector(new GuiceInjectorModule());
    }
}
