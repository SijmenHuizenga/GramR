package it.sijmen.gramr.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import it.sijmen.gramr.common.GuiceInjectorModule;

/**
 * Created by Sijmen on 4-4-2016.
 */
public abstract class AbstractServiceProvider<T extends AbstractService> {

    protected Injector createInjector(){
        return Guice.createInjector(new GuiceInjectorModule());
    }
}
