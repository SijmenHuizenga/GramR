package it.sijmen.gramr.photo.data;

import it.sijmen.gramr.common.pojo.Photo;
import it.sijmen.gramr.common.pojo.PhotoPrivacy;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Sijmen on 5-4-2016.
 */
public interface PhotoDAO {

    ArrayList<PhotoPrivacy> getPhotosBySet(String setName) throws IOException;

    Photo getPhoto(int id) throws IOException;

    Photo[] getAllPhotos() throws IOException;
}
