package it.sijmen.gramr.set.presentation;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import it.sijmen.gramr.common.pojo.PhotoPrivacy;
import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.common.presentation.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sijmen on 5-4-2016.
 */
@Singleton
public class SetController extends AbstractController {

    @Inject
    private SetModel setModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = getUser(req);
        String setName = getParameter("name");

        if(user == null || setName == null){
            resp.sendRedirect("/");
            return;
        }

        Set set = setModel.getSet(setName, user);

        if(set == null){
            resp.sendRedirect("/");
            return;
        }

        boolean canEdit = user.equals(set.getOwner());

        if(canEdit){
            doDellPhoto(set, user);
            doToglleOpen(set, user);
        }


        req.setAttribute("set", set);
        req.setAttribute("user", user);

        req.setAttribute("showEditThings", canEdit);

        show(req, resp, "SetView");
    }

    private void doToglleOpen(Set set, String user) {
        String photoToToggle = getParameter("toggleOpen");
        if(photoToToggle == null)
            return;

        int id = Integer.valueOf(photoToToggle);

        setModel.toggleOpenPhotoInSet(set.getName(), id, user);

        //todo: dit zout automatisch gedaan kunnen worden?
        PhotoPrivacy thePhoto = set.getPhoto(id);
        if(thePhoto != null)
            thePhoto.toggleOpen();

    }

    private void doDellPhoto(Set set, String user) {
        String photoToDel = getParameter("delPhoto");
        if(photoToDel == null)
            return;

        int id = Integer.valueOf(photoToDel);

        setModel.deletePhotoFromSet(set.getName(), id, user);

        //todo: dit kan toch automatoisch?
        set.removePhoto(id);
    }

}
