package it.sijmen.gramr.example.service.providers;

import it.sijmen.gramr.common.service.PojoResponse;
import it.sijmen.gramr.common.service.responses.ErrorResponse;
import it.sijmen.gramr.common.service.responses.SuccessResponse;
import it.sijmen.gramr.example.service.ExampleService;
import it.sijmen.gramr.example.service.ExampleServiceProvider;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Sijmen on 4-4-2016.
 */
@Singleton
@Path("/exampledata")
public class ExampleRestServiceProvider extends ExampleServiceProvider{

    protected ExampleService theService;

    public ExampleRestServiceProvider() {
        this.theService = createInjector().getInstance(ExampleService.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PojoResponse getTheData() {
        try {
            return new SuccessResponse(theService.getData());
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        }
    }

}
