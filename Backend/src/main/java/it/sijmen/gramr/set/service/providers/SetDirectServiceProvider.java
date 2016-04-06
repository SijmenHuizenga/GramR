package it.sijmen.gramr.set.service.providers;

import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.set.service.SetService;
import it.sijmen.gramr.set.service.SetServiceProvider;

import java.io.IOException;

/**
 * Created by Sijmen on 4-4-2016.
 */
public class SetDirectServiceProvider extends SetServiceProvider {

    protected SetService theService;

    public SetDirectServiceProvider() {
        this.theService = createInjector().getInstance(SetService.class);
    }

    public Set[] getSetsByUser(String user) throws IOException {
        return theService.getSetsByUser(user);
    }

    public Set getSet(String name, String user) throws IOException {
        return theService.getSet(name, user);
    }

    public void deletePhotoFromSet(String setName, int photoId, String user) throws IOException{
        theService.deletePhotoFromSet(setName, photoId, user);
    }

    public void toggleOpenPhotoInSet(String setName, int photoId, String user) throws IOException{
        theService.toggleOpenPhotoInSet(setName, photoId, user);
    }

    public void addPhotoToSet(String setName, int photoId, String user) throws IOException {
        theService.addPhotoToSet(setName, photoId, user);
    }

}
