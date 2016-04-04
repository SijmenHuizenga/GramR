package it.sijmen.gramr.set.service;

import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.service.AbstractServiceProvider;

import java.io.IOException;

/**
 * Created by Sinius on 4-4-2016.
 */
public class SetServiceProvider extends AbstractServiceProvider<SetService> {

    protected SetService theService;

    public SetServiceProvider() {
        this.theService = createInjector().getInstance(SetService.class);
    }

    protected Set[] getSetsByUser(String user) throws IOException {
        return theService.getSetsByUser(user);
    }

}
