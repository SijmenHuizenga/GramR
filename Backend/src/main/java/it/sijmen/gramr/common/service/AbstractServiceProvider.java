package it.sijmen.gramr.common.service;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by Sijmen on 4-4-2016.
 */
public abstract class AbstractServiceProvider<T extends AbstractService> {

    //awwww, dit gaat niet werken....
//    @Inject
//    protected T theService;
//
//    public AbstractServiceProvider() {
//        createInjector().injectMembers(this);
//    }

    protected Injector createInjector(){
        return Guice.createInjector(new GuiceInjectorModule());
    }

}
