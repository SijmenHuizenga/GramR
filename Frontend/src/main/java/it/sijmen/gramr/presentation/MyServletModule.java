package it.sijmen.gramr.presentation;

import com.google.inject.servlet.ServletModule;
import it.sijmen.gramr.example.presentation.ExampleController;
import it.sijmen.gramr.example.ExampleModel;
import it.sijmen.gramr.example.model.ExampleRestModel;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class MyServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        serve("/example/*").with(ExampleController.class);

        bind(ExampleModel.class).to(ExampleRestModel.class);
    }
}
