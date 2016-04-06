package it.sijmen.gramr.common.service.responses;

import it.sijmen.gramr.common.service.PojoResponse;

/**
 * Created by Sinius on 6-4-2016.
 */
public class SuccessResponse extends PojoResponse {

    private Object data;

    public SuccessResponse(Object data) {
        super("ok");
        this.data = data;
    }

    public SuccessResponse() {
        super("ok");
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
