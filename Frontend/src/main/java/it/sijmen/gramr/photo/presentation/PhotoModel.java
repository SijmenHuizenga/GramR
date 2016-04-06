package it.sijmen.gramr.photo.presentation;

import it.sijmen.gramr.common.pojo.Filter;
import it.sijmen.gramr.common.pojo.Photo;

/**
 * Created by Sijmen on 5-4-2016.
 */
public interface PhotoModel {

    Photo[] getAllPhotos();

    Photo getPhotoById(int id);

    boolean setFilter(int photoId, Filter filter, String user);
}
