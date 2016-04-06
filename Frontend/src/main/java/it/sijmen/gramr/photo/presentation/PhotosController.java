package it.sijmen.gramr.photo.presentation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import it.sijmen.gramr.common.pojo.Photo;
import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.common.presentation.AbstractController;
import it.sijmen.gramr.set.presentation.SetModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sinius on 4-4-2016.
 */
@Singleton
public class PhotosController extends AbstractController {

    @Inject
    private PhotoModel photoModel;

    @Inject
    private SetModel setModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Photo[] allPhotos = photoModel.getAllPhotos();

        if(getParameter("addToSet") != null) {
            boolean shouldShowPage = doAddtoSet(req, resp);
            if(!shouldShowPage)
                return;
        }

        req.setAttribute("photosList", allPhotos);


        show(req, resp, "PhotosView");
    }

    private boolean doAddtoSet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String user = getUser(req);

        Set theSet = setModel.getSet(getParameter("addToSet"), user);

        if(theSet == null || !theSet.getOwner().equals(user)) {
            resp.sendRedirect("/");
            return false;
        }

        String setName = getParameter("addToSet");
        String photoIdString = getParameter("id");
        if(setName == null) {
            resp.sendRedirect("/");
            return false;
        }

        if(photoIdString != null){
            int photoId = Integer.valueOf(photoIdString);
            boolean success = setModel.addPhotoToSet(setName, photoId, user);
            if(success) {
                resp.sendRedirect("/set?name=" + setName);
                return false;
            }
        }

        req.setAttribute("addToSetModeEnabled", true);
        req.setAttribute("addToSetSet", theSet);

        return true;
    }
}
