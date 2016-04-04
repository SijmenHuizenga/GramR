package it.sijmen.gramr.common.pojo;

import java.util.ArrayList;

/**
 * Created by Sijmen on 4-4-2016.
 */
public class Set {

    private String owner, name;
    private ArrayList<PhotoPrivacy> photos;

    public Set(String owner, String name, ArrayList<PhotoPrivacy> photos) {
        this.owner = owner;
        this.name = name;
        this.photos = photos;
    }

    public Set(String owner, String name) {
        this(owner, name, new ArrayList<>());
    }

    public void addPhoto(Photo photo, boolean open){
        this.photos.add(new PhotoPrivacy(photo, open));
    }

    public ArrayList<PhotoPrivacy> getPhotos(boolean includeClosed){
        ArrayList<Photo> output = new ArrayList<>();
        for(PhotoPrivacy photo : this.photos){
            if(!includeClosed && !photo.isOpen())
                continue;
            output.add(photo.getPhoto());
        }
        return photos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }
}
