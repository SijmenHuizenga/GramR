package it.sijmen.gramr.set.service.providers;

import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.set.service.SetServiceProvider;

import java.io.IOException;

/**
 * Created by Sinius on 4-4-2016.
 */
public class SetDirectServiceProvider extends SetServiceProvider {

    @Override
    public Set[] getSetsByUser(String user) throws IOException {
        return super.getSetsByUser(user);
    }
}
