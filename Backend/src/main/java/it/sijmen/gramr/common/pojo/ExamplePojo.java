package it.sijmen.gramr.common.pojo;

import java.util.ArrayList;

/**
 * Created by Sinius on 4-4-2016.
 */
public class ExamplePojo {

    private ArrayList<String> data;

    public ExamplePojo() {
        this.data = new ArrayList<>();
    }

    public String[] getData() {
        return data.toArray(new String[data.size()]);
    }

    public void addData(String data) {
        this.data.add(data);
    }
}
