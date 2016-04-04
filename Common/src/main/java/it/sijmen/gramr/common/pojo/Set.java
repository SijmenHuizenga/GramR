package it.sijmen.gramr.common.pojo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Sijmen on 4-4-2016.
 */
public class Set {

    private String owner, name;
    private PhotoPrivacy[] photos;

    public Set(String owner, String name, PhotoPrivacy[] photos) {
        this.owner = owner;
        this.name = name;
        this.photos = photos;
    }

    public Set(String owner, String name) {
        this(owner, name, new PhotoPrivacy[0]);
    }

    public void addPhoto(Photo photo, boolean open){
        photos = Arrays.copyOf(photos, photos.length+1);
        photos[photos.length-1] = new PhotoPrivacy(photo, open);
    }

    public ArrayList<Photo> getPhotos(boolean includeClosed){
        ArrayList<Photo> output = new ArrayList<>();
        for(PhotoPrivacy photo : this.photos){
            if(!includeClosed && !photo.isOpen())
                continue;
            output.add(photo.getPhoto());
        }
        return output;
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

    public int getPhotoAmount(boolean includeClosed){
        return getPhotos(includeClosed).size();
    }
}
