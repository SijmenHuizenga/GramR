package it.sijmen.gramr.photo.model;

import it.sijmen.gramr.common.pojo.Filter;
import it.sijmen.gramr.common.pojo.Photo;
import it.sijmen.gramr.filter.service.providers.FilterDirectServiceProvider;
import it.sijmen.gramr.photo.PhotoModel;
import it.sijmen.gramr.photo.service.providers.PhotoDirectServiceProvider;

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
    PhotoDirectServiceProvider photoProvider = new PhotoDirectServiceProvider();

    FilterDirectServiceProvider filterProvider = new FilterDirectServiceProvider();

    @Override
    public Photo[] getAllPhotos() {
        try {
            return photoProvider.getAllPhotos();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Photo getPhotoById(int id) {
        try {
            return photoProvider.getPhotoById(id);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean setFilter(int photoId, Filter filter, String user) {
        try {
            filterProvider.setPhotoFilter(photoId, filter, user);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
