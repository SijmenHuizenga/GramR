package it.sijmen.gramr.filter.data;

import it.sijmen.gramr.common.pojo.Filter;

import java.io.IOException;

/**
 * Created by Sinius on 5-4-2016.
 */
public interface FilterDAO {

    Filter getPhotoFilter(int photoId) throws IOException;

    void setPhotoFilter(int photoId, Filter filter) throws IOException;

}
