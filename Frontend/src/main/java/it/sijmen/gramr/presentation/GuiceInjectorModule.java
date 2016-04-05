package it.sijmen.gramr.presentation;

import com.google.inject.servlet.ServletModule;
import it.sijmen.gramr.example.ExampleController;
import it.sijmen.gramr.example.ExampleModel;
import it.sijmen.gramr.example.model.ExampleDirectModel;
import it.sijmen.gramr.example.model.ExampleHttpModel;
import it.sijmen.gramr.example.model.ExampleRestModel;
import it.sijmen.gramr.home.HomeController;
import it.sijmen.gramr.set.SetController;
import it.sijmen.gramr.set.SetsController;
import it.sijmen.gramr.set.SetModel;
import it.sijmen.gramr.set.models.SetDirectModel;

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

//        serve("/photo*").with(PhotoController.class);
//        serve("/photos*").with(PhotosController.class);

        serve("/").with(HomeController.class);

        switch (communicationType){
            case HTTP:
                bind(ExampleModel.class).to(ExampleHttpModel.class);
                break;
            case REST:
                bind(ExampleModel.class).to(ExampleRestModel.class);
                break;
            default: //default is DIRECT.
                bind(ExampleModel.class).to(ExampleDirectModel.class);
                bind(SetModel.class).to(SetDirectModel.class);
                break;
        }

    }

    enum CommunicationType {
        DIRECT, HTTP, REST
    }
}
