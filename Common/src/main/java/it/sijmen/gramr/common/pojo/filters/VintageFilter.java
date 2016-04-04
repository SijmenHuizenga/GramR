package it.sijmen.gramr.common.pojo.filters;

import it.sijmen.gramr.common.pojo.Filter;

/**
 * Created by Sijmen on 4-4-2016.
 */
public class VintageFilter extends Filter {

    private int upperLeftX, upperLeftY, lowerRightX, lowerRightY;

    public VintageFilter() {
        super("Vintage Filter: Make everything vintage alike");
    }

    public VintageFilter(int upperLeftX, int upperLeftY, int lowerRightX, int lowerRightY) {
        this();
        this.upperLeftX = upperLeftX;
        this.upperLeftY = upperLeftY;
        this.lowerRightX = lowerRightX;
        this.lowerRightY = lowerRightY;
    }

    public int getUpperLeftX() {
        return upperLeftX;
    }

    public void setUpperLeftX(int upperLeftX) {
        this.upperLeftX = upperLeftX;
    }

    public int getUpperLeftY() {
        return upperLeftY;
    }

    public void setUpperLeftY(int upperLeftY) {
        this.upperLeftY = upperLeftY;
    }

    public int getLowerRightX() {
        return lowerRightX;
    }

    public void setLowerRightX(int lowerRightX) {
        this.lowerRightX = lowerRightX;
    }

    public int getLowerRightY() {
        return lowerRightY;
    }

    public void setLowerRightY(int lowerRightY) {
        this.lowerRightY = lowerRightY;
    }
}
