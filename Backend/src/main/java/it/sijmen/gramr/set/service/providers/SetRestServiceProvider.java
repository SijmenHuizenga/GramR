package it.sijmen.gramr.set.service.providers;

import it.sijmen.gramr.common.service.PojoResponse;
import it.sijmen.gramr.common.service.responses.ErrorResponse;
import it.sijmen.gramr.common.service.responses.SuccessResponse;
import it.sijmen.gramr.set.service.SetServiceProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Sinius on 6-4-2016.
 */
@Path("/set")
public class SetRestServiceProvider extends SetServiceProvider {

    @GET
    @Path("/get/{user}/{setid}")
    @Produces(MediaType.APPLICATION_JSON)
    public PojoResponse getSet(
            @PathParam("setid") String name,
            @PathParam("user") String user) {

        try {
            return new SuccessResponse(theService.getSet(name, user));
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        }
    }

    @GET
    @Path("/get/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public PojoResponse getSetsByUser(
            @PathParam("user") String user) {

        try {
            return new SuccessResponse(theService.getSetsByUser(user));
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        }
    }

    @GET
    @Path("/deletephoto/{user}/{setname}/{photoid}")
    @Produces(MediaType.APPLICATION_JSON)
    public PojoResponse deletePhotoFromSet(
            @PathParam("setname") String setName,
            @PathParam("photoid") int photoId,
            @PathParam("user") String user) {

        try {
            theService.deletePhotoFromSet(setName, photoId, user);
            return new SuccessResponse();
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        }
    }

    @GET
    @Path("/addphoto/{user}/{setname}/{photoid}")
    @Produces(MediaType.APPLICATION_JSON)
    public PojoResponse addPhotoToSet(
            @PathParam("setname") String setName,
            @PathParam("photoid") int photoId,
            @PathParam("user") String user) {
        try {
            theService.addPhotoToSet(setName, photoId, user);
            return new SuccessResponse();
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        }
    }

    @GET
    @Path("/toggleopen/{user}/{setname}/{photoid}")
    @Produces(MediaType.APPLICATION_JSON)
    public PojoResponse toggleOpenPhotoInSet(
            @PathParam("setname") String setName,
            @PathParam("photoid") int photoId,
            @PathParam("user") String user) {
        try {
            theService.toggleOpenPhotoInSet(setName, photoId, user);
            return new SuccessResponse();
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        }
    }

}
