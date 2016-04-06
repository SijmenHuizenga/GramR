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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExamplePojo that = (ExamplePojo) o;

        return getId() == that.getId() && !(getData() != null ? !getData().equals(that.getData()) : that.getData() != null);

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        return result;
    }
}
