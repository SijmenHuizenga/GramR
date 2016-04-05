package it.sijmen.gramr.common.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public PhotoPrivacy[] getPhotos() {
        return photos;
    }

    public PhotoPrivacy getPhoto(int id){
        for(PhotoPrivacy photo : photos){
            if(photo.getPhoto().getId() == id)
                return photo;
        }
        return null;
    }

    public void setPhotos(ArrayList<PhotoPrivacy> photos) {
        this.photos = photos.toArray(new PhotoPrivacy[photos.size()]);
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

    public int getPhotoAmount(){
        return getPhotos().length;
    }

    public void removePhoto(int id) {
        List<PhotoPrivacy> list = new ArrayList<PhotoPrivacy>(Arrays.asList(photos));
        int toDel = -1;
        for (int i = 0; i < list.size(); i++) {
            PhotoPrivacy photoPrivacy = list.get(i);
            if (photoPrivacy.getPhoto().getId() == id)
                toDel = i;
        }
        if(toDel == -1)
            return;
        list.remove(toDel);
        photos = list.toArray(new PhotoPrivacy[list.size()]);
    }
}
