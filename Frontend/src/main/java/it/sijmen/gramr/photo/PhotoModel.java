package it.sijmen.gramr.photo;

import it.sijmen.gramr.common.pojo.Photo;

/**
 * Created by Sinius on 5-4-2016.
 */
public interface PhotoModel {

    Photo[] getAllPhotos();

    Photo getPhotoById(int id);

}
