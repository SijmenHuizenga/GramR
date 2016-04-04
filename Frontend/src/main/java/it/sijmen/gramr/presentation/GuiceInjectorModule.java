package it.sijmen.gramr.presentation;

import com.google.inject.servlet.ServletModule;
import it.sijmen.gramr.example.ExampleController;
import it.sijmen.gramr.example.ExampleModel;
import it.sijmen.gramr.example.model.ExampleDirectModel;
import it.sijmen.gramr.example.model.ExampleRestModel;
import it.sijmen.gramr.home.HomeController;
import it.sijmen.gramr.set.SetController;
import it.sijmen.gramr.set.SetModel;
import it.sijmen.gramr.set.models.SetDirectModel;

import java.util.Map;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class GuiceInjectorModule extends ServletModule {



    @Override
    protected void configureServlets() {
        serve("/example/*").with(ExampleController.class);
        serve("/sets*").with(SetController.class);

        serve("/").with(HomeController.class);

        bind(ExampleModel.class).to(ExampleDirectModel.class);
        bind(SetModel.class).to(SetDirectModel.class);
    }
}
