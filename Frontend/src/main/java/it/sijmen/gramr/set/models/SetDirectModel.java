package it.sijmen.gramr.set.models;

import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.set.SetModel;
import it.sijmen.gramr.set.service.providers.SetDirectServiceProvider;

import java.io.IOException;

/**
 * Created by Sinius on 4-4-2016.
 */
public class SetDirectModel implements SetModel {
    @Override
    public Set[] getSetsByUser(String username) {
        SetDirectServiceProvider provider = new SetDirectServiceProvider();
        try {
            return provider.getSetsByUser(username);
        } catch (IOException e) {
            e.printStackTrace();
            return new Set[0];
        }
    }

    @Override
    public Set getSet(String name, String user) {
        //deze moet elke keer opnieuw ivm dichten van de database connectie.
        SetDirectServiceProvider provider = new SetDirectServiceProvider();
        try {
            return provider.getSet(name, user);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deletePhotoFromSet(String setName, int photoId, String user) {
        SetDirectServiceProvider provider = new SetDirectServiceProvider();
        try {
            provider.deletePhotoFromSet(setName, photoId, user);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
