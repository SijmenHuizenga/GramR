package it.sijmen.gramr.photo.service;

import com.google.inject.Inject;
import it.sijmen.gramr.common.pojo.Photo;
import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.photo.data.PhotoDAO;
import it.sijmen.gramr.service.AbstractService;

import java.io.IOException;

/**
 * Created by Sinius on 5-4-2016.
 */
public class PhotoService extends AbstractService {

    private PhotoDAO photoDAO;

    @Inject
    public PhotoService(PhotoDAO photoDAO){
        this.photoDAO = photoDAO;
    }

    public Photo[] getAllPhotos() throws IOException {
        return photoDAO.getAllPhotos();
    }

    public Photo getPhotoById(int id) throws IOException {
        return photoDAO.getPhoto(id);
    }

}
