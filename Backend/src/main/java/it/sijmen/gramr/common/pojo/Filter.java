package it.sijmen.gramr.common.pojo;

/**
 * Created by Sijmen on 4-4-2016.
 */
public abstract class Filter {

    private String description;

    public Filter(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
