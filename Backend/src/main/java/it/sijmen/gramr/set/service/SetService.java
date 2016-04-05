package it.sijmen.gramr.set.service;

import com.google.inject.Inject;
import it.sijmen.gramr.common.pojo.PhotoPrivacy;
import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.photo.data.PhotoDAO;
import it.sijmen.gramr.service.AbstractService;
import it.sijmen.gramr.set.data.SetDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Sinius on 4-4-2016.
 */
public class SetService extends AbstractService {

    private SetDAO setDAO;
    private PhotoDAO photoDAO;

    @Inject
    public SetService(SetDAO setDAO, PhotoDAO photoDAO){
        this.setDAO = setDAO;
        this.photoDAO = photoDAO;
    }

    /**
     * Geeft alle sets van een bepaalde user waarvan deze user eigenaar is.
     */
    public Set[] getSetsByUser(String user) throws IOException {
        ArrayList<Set> sets = setDAO.getSetsByUser(user);
        for (Set set : sets)
            set.setPhotos(photoDAO.getPhotosBySet(set.getName()));
        return sets.toArray(new Set[sets.size()]);
    }

    /**
     * Geeft een set (aan de hand van de gegeven naam) en geeft daarbij
     * alleen de photo's waar de gegeven gebruiker toegang tot heeft.
     *
     * Dus set A kan bij Sijmen 5 photos opleveren en bij Tim 2 photos.
     */
    public Set getSet(String name, String user) throws IOException{
        Set set = setDAO.getSet(name);

        ArrayList<PhotoPrivacy> photos = photoDAO.getPhotosBySet(set.getName());
        for (PhotoPrivacy photo : photos) {
            if(photo.isOpen() || set.getOwner().equals(user))
                set.addPhoto(photo.getPhoto(), photo.isOpen());
        }

        return set;
    }

    public void deletePhotoFromSet(String setName, int id, String user) throws IOException{
        Set theSet = setDAO.getSet(setName);

        if(!theSet.getOwner().equals(user))
            throw new IllegalArgumentException("The user is not the owner of the set and so cannot delete a photo from it.");

        setDAO.deletePhotoFromSet(theSet.getName(), id);
    }

}
