package it.sijmen.gramr.common.service;

/**
 * Created by Sinius on 6-4-2016.
 */
public abstract class PojoResponse {

    private String status;

    public PojoResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
