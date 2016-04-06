package it.sijmen.gramr.photo.service;

import com.google.inject.Inject;
import it.sijmen.gramr.common.pojo.Photo;
import it.sijmen.gramr.common.service.AbstractService;
import it.sijmen.gramr.filter.data.FilterDAO;
import it.sijmen.gramr.photo.data.PhotoDAO;
import java.io.IOException;

/**
 * Created by Sinius on 5-4-2016.
 */
public class PhotoService extends AbstractService {

    @Inject
    private PhotoDAO photoDAO;

    @Inject
    private FilterDAO filterDAO;

    public Photo[] getAllPhotos() throws IOException {
        Photo[] photos = photoDAO.getAllPhotos();
        for (Photo photo : photos)
            photo.setFilter(filterDAO.getPhotoFilter(photo.getId()));
        return photos;
    }

    public Photo getPhotoById(int id) throws IOException {
        Photo photo = photoDAO.getPhoto(id);
        if(photo != null)
            photo.setFilter(filterDAO.getPhotoFilter(photo.getId()));
        return photo;
    }

}
