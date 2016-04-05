package it.sijmen.gramr.photo.service.providers;

import it.sijmen.gramr.common.pojo.Photo;
import it.sijmen.gramr.photo.service.PhotoServiceProvider;

import java.io.IOException;

/**
 * Created by Sinius on 5-4-2016.
 */
public class PhotoDirectServiceProvider extends PhotoServiceProvider {

    public Photo[] getAllPhotos() throws IOException {
        return theService.getAllPhotos();
    }

    public Photo getPhotoById(int id) throws IOException {
        return theService.getPhotoById(id);
    }

}
