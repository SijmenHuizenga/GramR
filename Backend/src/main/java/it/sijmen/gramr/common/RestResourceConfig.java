package it.sijmen.gramr.common;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by Sijmen on 4-4-2016.
 */
@ApplicationPath("/rest")
public class RestResourceConfig extends ResourceConfig {

    public static final String JSON_SERIALIZER = "jersey.config.server.provider.packages";
    public static final String JACKSON_JSON_SERIALIZER = "com.fasterxml.jackson.jaxrs.json;it.sijmen.gramr";

    public RestResourceConfig(){
        packages(true, "it.sijmen.gramr");
        property(JSON_SERIALIZER, JACKSON_JSON_SERIALIZER);
    }


}
