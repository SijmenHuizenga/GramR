package it.sijmen.gramr.set.presentation;

import it.sijmen.gramr.common.pojo.Set;

/**
 * Created by Sinius on 4-4-2016.
 */
public interface SetModel {

    /**
     * Geef alle sets waar een user eigenaar van is.
     */
    Set[] getSetsByUser(String username);

    /**
     * Zoek een Set bij een 'name' en vul die set met
     * de photo's waar de gegeven 'user' toegang tot heeft.
     */
    Set getSet(String name, String user);

    /**
     * Verwijder een Photo van een bepaalde set.
     */
    boolean deletePhotoFromSet(String setName, int photoId, String user);

    /**
     * Toggelt de boolean 'open' binnen voor een foto binnen een Set
     */
    boolean toggleOpenPhotoInSet(String setName, int photoId, String user);

    /**
     * Voeg een bestaande Photo toe aan een Set.
     */
    boolean addPhotoToSet(String setName, int photoId, String user);
}
