package it.sijmen.gramr.photo;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import it.sijmen.gramr.common.pojo.Photo;
import it.sijmen.gramr.presentation.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sinius on 4-4-2016.
 */
@Singleton
public class PhotoController extends Controller {

    @Inject
    private PhotoModel photoModel;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String photoId = getParameter("id");
        if(photoId == null){
            resp.sendRedirect("/");
            return;
        }

        Photo thePhoto = photoModel.getPhotoById(Integer.valueOf(photoId));

        String user = getUser(req);
        boolean canEdit = thePhoto.getCreator().equals(user);

        req.setAttribute("canEdit", canEdit);
        req.setAttribute("thePhoto", thePhoto);

        show(req, resp, "PhotoView");
    }
}
