package it.sijmen.gramr.set.models;

import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.set.SetModel;
import it.sijmen.gramr.set.service.providers.SetDirectServiceProvider;

import java.io.IOException;

/**
 * Created by Sinius on 4-4-2016.
 */
public class SetDirectModel implements SetModel {

    //todo: is het wel goed dat deze open wordt gehouden de heel tijd? Ookal zijn er geen requests?
    /**
     * Kan niet worden Injected omdat de ServiceProviders een eigen injector hebben.
     *
     * Bij een @Inject gaat Guice proberen ook de childs te injecten, maar dat wordt
     * binnen de serviceProvder zelf geregeld.
     */
    SetDirectServiceProvider provider = new SetDirectServiceProvider();

    @Override
    public Set[] getSetsByUser(String username) {
        try {
            return provider.getSetsByUser(username);
        } catch (IOException e) {
            e.printStackTrace();
            return new Set[0];
        }
    }

    @Override
    public Set getSet(String name, String user) {
        try {
            return provider.getSet(name, user);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deletePhotoFromSet(String setName, int photoId, String user) {
        try {
            provider.deletePhotoFromSet(setName, photoId, user);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean toggleOpenPhotoInSet(String setName, int photoId, String user) {
        try {
            provider.toggleOpenPhotoInSet(setName, photoId, user);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
