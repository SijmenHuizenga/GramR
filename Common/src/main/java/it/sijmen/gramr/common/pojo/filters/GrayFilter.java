package it.sijmen.gramr.common.pojo.filters;

import it.sijmen.gramr.common.pojo.Filter;

/**
 * Created by Sijmen on 4-4-2016.
 */
public class GrayFilter extends Filter {

    private int precentage;

    public GrayFilter() {
        super("Gray Filter");
    }

    public GrayFilter(int precentage) {
        this();
        this.precentage = precentage;
    }

    public int getPrecentage() {
        return precentage;
    }
}
