package it.sijmen.gramr.filter.service.providers;

import com.google.inject.Inject;
import it.sijmen.gramr.common.pojo.Filter;
import it.sijmen.gramr.common.pojo.filters.FilterFactory;
import it.sijmen.gramr.common.service.PojoResponse;
import it.sijmen.gramr.common.service.responses.ErrorResponse;
import it.sijmen.gramr.common.service.responses.SuccessResponse;
import it.sijmen.gramr.filter.service.FilterServiceProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Sijmen on 6-4-2016.
 */
@Path("/filter")
public class FilterRestServiceProvider extends FilterServiceProvider {

    @Inject
    FilterFactory filterFactory;

    @GET
    @Path("/{photoid}")
    @Produces(MediaType.APPLICATION_JSON)
    public PojoResponse getPhotoFilter(
            @PathParam("photoid") int photoId){

        try {
            return new SuccessResponse(theService.getPhotoFilter(photoId));
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        }
    }

    @Path("/set/{photoid}/{user}/{filterName}/{filterData}")
    public PojoResponse setPhotoFilter(
            @PathParam("photoid") int photoId,
            @PathParam("filterName") String filterName,
            @PathParam("filterData") String filterData,
            @PathParam("user") String user){

        Filter theFilter = filterFactory.createFilter(filterName);
        try {
            theService.setPhotoFilter(photoId, theFilter, user);
            return new SuccessResponse();
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        }
    }

}
