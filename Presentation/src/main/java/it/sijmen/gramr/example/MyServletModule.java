package it.sijmen.gramr.example;

import com.google.inject.servlet.ServletModule;
import it.sijmen.gramr.example.presentation.ExampleController;
import it.sijmen.gramr.example.presentation.ExampleModel;
import it.sijmen.gramr.example.presentation.model.ExampleHttpModel;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class MyServletModule extends ServletModule {

    @Override
    protected void configureServlets() {
        serve("/example/*").with(ExampleController.class);

        bind(ExampleModel.class).to(ExampleHttpModel.class);
    }
}
