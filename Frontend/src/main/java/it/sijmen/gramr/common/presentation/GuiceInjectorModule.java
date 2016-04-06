package it.sijmen.gramr.common.presentation;

import com.google.inject.servlet.ServletModule;
import it.sijmen.gramr.example.presentation.ExampleController;
import it.sijmen.gramr.example.presentation.ExampleModel;
import it.sijmen.gramr.example.presentation.model.ExampleDirectModel;
import it.sijmen.gramr.example.presentation.model.ExampleHttpModel;
import it.sijmen.gramr.home.presentation.HomeController;
import it.sijmen.gramr.photo.presentation.PhotoController;
import it.sijmen.gramr.photo.presentation.PhotoModel;
import it.sijmen.gramr.photo.presentation.PhotosController;
import it.sijmen.gramr.photo.presentation.model.PhotoDirectModel;
import it.sijmen.gramr.set.presentation.SetController;
import it.sijmen.gramr.set.presentation.SetsController;
import it.sijmen.gramr.set.presentation.SetModel;
import it.sijmen.gramr.set.presentation.models.SetDirectModel;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class GuiceInjectorModule extends ServletModule {

    private final CommunicationType communicationType = CommunicationType.DIRECT;

    @Override
    protected void configureServlets() {
        serve("/example/*").with(ExampleController.class);
        serve("/sets*").with(SetsController.class);
        serve("/set*").with(SetController.class);

        serve("/photos*").with(PhotosController.class);
        serve("/photo*").with(PhotoController.class);

        serve("/").with(HomeController.class);

        switch (communicationType){
            case HTTP:
                bind(ExampleModel.class).to(ExampleHttpModel.class);
                break;
            case REST:
//                bind(ExampleModel.class).to(ExampleRestModel.class);
                break;
            default: //default is DIRECT.
                bind(ExampleModel.class).to(ExampleDirectModel.class);
                bind(SetModel.class).to(SetDirectModel.class);
                bind(PhotoModel.class).to(PhotoDirectModel.class);
                break;
        }

    }

    enum CommunicationType {
        DIRECT, HTTP, REST
    }
}
