package it.sijmen.gramr.photo.service.providers;

import it.sijmen.gramr.common.service.PojoResponse;
import it.sijmen.gramr.common.service.responses.ErrorResponse;
import it.sijmen.gramr.common.service.responses.SuccessResponse;
import it.sijmen.gramr.photo.service.PhotoServiceProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Sinius on 6-4-2016.
 */
@Path("/photo")
public class PhotoRestServiceProvider extends PhotoServiceProvider{

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public PojoResponse getAllPhotos() {
        try {
            return new SuccessResponse(theService.getAllPhotos());
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        }
    }

    @GET
    @Path("/{photoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public PojoResponse getPhotoById(
            @PathParam("photoId") int id) {

        try {
            return new SuccessResponse(theService.getPhotoById(id));
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        }
    }

}
