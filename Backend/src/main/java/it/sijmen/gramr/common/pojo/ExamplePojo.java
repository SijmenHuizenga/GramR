package it.sijmen.gramr.common.pojo;

/**
 * Created by Sijmen on 4-4-2016.
 */
public class ExamplePojo {

    private int id;
    private String data;

    public ExamplePojo() {
    }

    public ExamplePojo(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
