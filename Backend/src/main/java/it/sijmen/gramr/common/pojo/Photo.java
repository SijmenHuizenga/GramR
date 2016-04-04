package it.sijmen.gramr.common.pojo;

/**
 * Created by Sijmen on 4-4-2016.
 */
public class Photo {

    private int id;
    private String creator, title, url, description;
    private Filter filter;

    public Photo(int id, String creator, String title, String url, String description, Filter filter) {
        this.id = id;
        this.creator = creator;
        this.title = title;
        this.url = url;
        this.description = description;
        this.filter = filter;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public int getId() {
        return id;
    }

    public String getCreator() {
        return creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
