package it.sijmen.gramr.filter.service.providers;

import it.sijmen.gramr.common.pojo.Filter;
import it.sijmen.gramr.filter.service.FilterService;
import it.sijmen.gramr.filter.service.FilterServiceProvider;

import java.io.IOException;

/**
 * Created by Sinius on 5-4-2016.
 */
public class FilterDirectServiceProvider extends FilterServiceProvider {

    protected FilterService theService;

    public FilterDirectServiceProvider() {
        this.theService = createInjector().getInstance(FilterService.class);
    }

    public Filter getPhotoFilter(int photoId) throws IOException {
        return theService.getPhotoFilter(photoId);
    }

    public void setPhotoFilter(int photoId, Filter filter, String user) throws IOException {
        theService.setPhotoFilter(photoId, filter, user);
    }

}
