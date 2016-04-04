package it.sijmen.gramr.example;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import it.sijmen.gramr.common.data.jdbc.JdbcDatabaseConnectionFactory;
import it.sijmen.gramr.example.data.ExampleDAO;
import it.sijmen.gramr.example.data.daos.ExampleJDBCDAO;

import java.sql.Connection;

/**
 * Created by Sijmen on 3-4-2016.
 */
public class MyModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("HelloWorldTxt")).toInstance("hallo wereld mensen!");

        bind(String.class).annotatedWith(Names.named("Jdbc Driver Class String")).toInstance("com.mysql.jdbc.Driver");
        bind(String.class).annotatedWith(Names.named("Jdbc Connection String")).toInstance("jdbc:mysql://localhost:3306/GramR");
        bind(String.class).annotatedWith(Names.named("Jdbc Connection Username String")).toInstance("GramRUser");
        bind(String.class).annotatedWith(Names.named("Jdbc Connection Password String")).toInstance("somerandompasswordnobodyknows");

        bind(Connection.class).toProvider(JdbcDatabaseConnectionFactory.class);

        bind(ExampleDAO.class).to(ExampleJDBCDAO.class);



    }

}
