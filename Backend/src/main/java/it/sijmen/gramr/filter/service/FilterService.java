package it.sijmen.gramr.filter.service;

import com.google.inject.Inject;
import it.sijmen.gramr.common.pojo.Filter;
import it.sijmen.gramr.common.pojo.Photo;
import it.sijmen.gramr.common.service.AbstractService;
import it.sijmen.gramr.filter.data.FilterDAO;
import it.sijmen.gramr.photo.data.PhotoDAO;

import java.io.IOException;

/**
 * Created by Sinius on 5-4-2016.
 */
public class FilterService extends AbstractService {

    @Inject
    private FilterDAO filterDAO;

    @Inject
    private PhotoDAO photoDAO;

    public Filter getPhotoFilter(int photoId) throws IOException {
        Photo photo = photoDAO.getPhoto(photoId);
        if (photo == null)
            throw new IllegalArgumentException("Could not found photo.");

        return filterDAO.getPhotoFilter(photoId);
    }

    public void setPhotoFilter(int photoId, Filter filter, String user) throws IOException {
        Photo photo = photoDAO.getPhoto(photoId);
        if (photo == null)
            throw new IllegalArgumentException("Could not found photo.");

        if(!photo.getCreator().equals(user))
            throw new IllegalArgumentException("The user is not the owner of the photo and so cannot set data in it.");

        photo.setFilter(filter);
        filterDAO.setPhotoFilter(photo.getId(), filter);
    }

}
