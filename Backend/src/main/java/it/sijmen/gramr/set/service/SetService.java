package it.sijmen.gramr.set.service;

import com.google.inject.Inject;
import it.sijmen.gramr.common.pojo.Photo;
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

    /**
     * Verwijder een Photo uit een Set door een bepaalde Gebruiker.
     */
    public void deletePhotoFromSet(String setName, int id, String user) throws IOException{
        Set theSet = setDAO.getSet(setName);

        if(theSet == null || !theSet.getOwner().equals(user))
            throw new IllegalArgumentException("The user is not the owner of the set and so cannot delete a photo from it.");

        setDAO.deletePhotoFromSet(theSet.getName(), id);
    }

    /**
     * Toggle het 'open' attribuut binnen de klasse PhotoPrivacy
     */
    public void toggleOpenPhotoInSet(String setName, int photoId, String user) throws IOException{
        Set theSet = setDAO.getSet(setName);

        if(theSet == null || !theSet.getOwner().equals(user))
            throw new IllegalArgumentException("The user is not the owner of the set and so cannot set data in it.");

        ArrayList<PhotoPrivacy> photos = photoDAO.getPhotosBySet(theSet.getName());
        PhotoPrivacy thePhoto = findPhotoPrivacyInList(photos, photoId);
        if(thePhoto == null)
            throw new IllegalArgumentException("The given photo does not exist in this set.");

        thePhoto.toggleOpen();

        setDAO.savePhotoPrivacyInSet(theSet.getName(), thePhoto);
    }

    /**
     * Voeg een bestaande Photo toe aan een bestaande Set.
     */
    public void addPhotoToSet(String setName, int photoId, String user) throws IOException{
        Set theSet = setDAO.getSet(setName);

        if(theSet == null || !theSet.getOwner().equals(user))
            throw new IllegalArgumentException("The user is not the owner of the set and so cannot set data in it.");

        Photo thePhoto = photoDAO.getPhoto(photoId);
        if(thePhoto == null)
            throw new IllegalArgumentException("The photo could not be found.");

        setDAO.savePhotoPrivacyInSet(theSet.getName(), new PhotoPrivacy(thePhoto, false));

    }

    private PhotoPrivacy findPhotoPrivacyInList(ArrayList<PhotoPrivacy> list, int photoId){
        for (PhotoPrivacy photoPrivacy : list) {
            if(photoPrivacy.getPhoto().getId() == photoId)
                return photoPrivacy;
        }
        return null;
    }
}
