package it.sijmen.gramr.set.service;

import com.google.inject.Inject;
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

    public Set[] getSetsByUser(String user) throws IOException {
        ArrayList<Set> sets = setDAO.getSetsByUser(user);
        for (Set set : sets)
            photoDAO.fillPhotosInSet(set);

        return sets.toArray(new Set[sets.size()]);
    }

}
