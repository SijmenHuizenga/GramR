package it.sijmen.gramr.example.service.providers;

import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.service.ExampleServiceProvider;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Sijmen on 4-4-2016.
 */
@Singleton
@Path("/exampledata")
public class ExampleRestServiceProvider extends ExampleServiceProvider{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ExamplePojo getTheData() {
        try {
            return theService.getData();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
