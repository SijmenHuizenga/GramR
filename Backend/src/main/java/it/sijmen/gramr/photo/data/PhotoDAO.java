package it.sijmen.gramr.photo.data;

import it.sijmen.gramr.common.pojo.Set;

import java.io.IOException;

/**
 * Created by Sinius on 5-4-2016.
 */
public interface PhotoDAO {

    void fillPhotosInSet(Set set) throws IOException;

}
