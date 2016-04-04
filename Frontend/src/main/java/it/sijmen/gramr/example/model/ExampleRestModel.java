package it.sijmen.gramr.example.model;

import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.ExampleModel;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Sijmen on 4-4-2016.
 */
public class ExampleRestModel implements ExampleModel {

    public static final String JSON_SERIALIZER = "jersey.config.server.provider.packages";
    public static final String JACKSON_JSON_SERIALIZER = "com.fasterxml.jackson.jaxrs.json;it.sijmen.gramr";

    @Override
    public String getData() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8092/rest");
        target = target.property(JSON_SERIALIZER, JACKSON_JSON_SERIALIZER);
        target = target.path("exampledata");


        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        ExamplePojo pojo = builder.get(ExamplePojo.class);

        return pojo.getData();
    }
}
