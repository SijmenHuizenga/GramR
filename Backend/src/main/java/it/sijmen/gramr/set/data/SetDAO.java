package it.sijmen.gramr.set.data;

import it.sijmen.gramr.common.pojo.PhotoPrivacy;
import it.sijmen.gramr.common.pojo.Set;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Sijmen on 4-4-2016.
 */
public interface SetDAO {

    ArrayList<Set> getSetsByUser(String user) throws IOException;

    Set getSet(String setName) throws IOException;

    void deletePhotoFromSet(String setName, int photoId) throws IOException;

    void savePhotoPrivacyInSet(String setName, PhotoPrivacy photo) throws IOException;
}
