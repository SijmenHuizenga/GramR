package it.sijmen.gramr.common.pojo.filters;

import it.sijmen.gramr.common.pojo.Filter;

/**
 * Created by Sijmen on 5-4-2016.
 */
public class FilterFactory {

    public FilterFactory(){

    }

    public Filter createFilter(String name){
        if(name.equalsIgnoreCase("gray")){
            //todo: make dynamic
            return new GrayFilter(50);
        }else if(name.equalsIgnoreCase("vintage")){
            return new VintageFilter(1, 1, 5, 5);
        }
        return null;
    }

}
