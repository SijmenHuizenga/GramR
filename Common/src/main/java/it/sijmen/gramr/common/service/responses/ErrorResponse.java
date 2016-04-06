package it.sijmen.gramr.common.service.responses;

import it.sijmen.gramr.common.service.PojoResponse;

/**
 * Created by Sinius on 6-4-2016.
 */
public class ErrorResponse extends PojoResponse {

    private String error;

    public ErrorResponse(String error) {
        super("error");
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
