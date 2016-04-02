package it.sijmen.gramr.example;

import com.google.inject.name.Names;
import com.google.inject.servlet.ServletModule;
import it.sijmen.gramr.example.presentation.ExamplePageController;
import it.sijmen.gramr.example.presentation.ExamplePageModel;
import it.sijmen.gramr.example.presentation.model.ExamplePageDirectModel;
import it.sijmen.gramr.example.presentation.model.ExamplePageHttpModel;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class MyServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        serve("/example/*").with(ExamplePageController.class);

        bind(ExamplePageModel.class).to(ExamplePageHttpModel.class);
    }
}
