package it.sijmen.gramr.common.pojo;

/**
 * Created by Sijmen on 4-4-2016.
 */
public class PhotoPrivacy {

    private Photo photo;
    private boolean open;

    public PhotoPrivacy(Photo photo, boolean open) {
        this.photo = photo;
        this.open = open;
    }

    public boolean toggleOpen(){
        return this.open = !this.open;
    }

    public boolean isOpen() {
        return open;
    }

    public Photo getPhoto() {
        return photo;
    }
}
