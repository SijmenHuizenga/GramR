package it.sijmen.gramr.example.presentation.model;

import it.sijmen.gramr.example.presentation.ExampleModel;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Created by Sijmen on 4-4-2016.
 */
public class ExampleRestModel implements ExampleModel {

    @Override
    public String getData() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9998").path("resource");
    }
}
