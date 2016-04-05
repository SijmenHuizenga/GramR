package it.sijmen.gramr.photo.model;

import it.sijmen.gramr.common.pojo.Photo;
import it.sijmen.gramr.photo.PhotoModel;
import it.sijmen.gramr.photo.service.providers.PhtoDirectServiceProvider;

import java.io.IOException;

/**
 * Created by Sinius on 5-4-2016.
 */
public class PhotoDirectModel implements PhotoModel {

    /**
     * Kan niet worden Injected omdat de ServiceProviders een eigen injector hebben.
     *
     * Bij een @Inject gaat Guice proberen ook de childs te injecten, maar dat wordt
     * binnen de serviceProvder zelf geregeld.
     */
    PhtoDirectServiceProvider provider = new PhtoDirectServiceProvider();

    @Override
    public Photo[] getAllPhotos() {
        try {
            return provider.getAllPhotos();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Photo getPhotoById(int id) {
        try {
            return provider.getPhotoById(id);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
