package it.sijmen.gramr.service;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import it.sijmen.gramr.set.service.SetService;

/**
 * Created by Sijmen on 4-4-2016.
 */
public abstract class AbstractServiceProvider<T extends AbstractService> {

    @Inject
    protected T theService;

    public AbstractServiceProvider() {
        createInjector().injectMembers(this);
    }

    protected Injector createInjector(){
        return Guice.createInjector(new GuiceInjectorModule());
    }



}
