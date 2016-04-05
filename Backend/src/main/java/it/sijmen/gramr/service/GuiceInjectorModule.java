package it.sijmen.gramr.service;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import it.sijmen.gramr.data.jdbc.JdbcDatabaseConnectionFactory;
import it.sijmen.gramr.example.data.ExampleDAO;
import it.sijmen.gramr.example.data.daos.ExampleJDBCDAO;
import it.sijmen.gramr.filter.data.FilterDAO;
import it.sijmen.gramr.filter.data.dao.FilterJDBCDAO;
import it.sijmen.gramr.photo.data.PhotoDAO;
import it.sijmen.gramr.photo.data.dao.PhotoJDBCDAO;
import it.sijmen.gramr.set.data.SetDAO;
import it.sijmen.gramr.set.data.dao.SetJDBCDAO;

import java.sql.Connection;

/**
 * Created by Sijmen on 3-4-2016.
 */
public class GuiceInjectorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("Jdbc Driver Class String")).toInstance("com.mysql.jdbc.Driver");
        bind(String.class).annotatedWith(Names.named("Jdbc Connection String")).toInstance("jdbc:mysql://localhost:3306/GramR");
        bind(String.class).annotatedWith(Names.named("Jdbc Connection Username String")).toInstance("GramRUser");
        bind(String.class).annotatedWith(Names.named("Jdbc Connection Password String")).toInstance("somerandompasswordnobodyknows");

        bind(Connection.class).toProvider(JdbcDatabaseConnectionFactory.class);

        bind(ExampleDAO.class).to(ExampleJDBCDAO.class);
        bind(SetDAO.class).to(SetJDBCDAO.class);
        bind(PhotoDAO.class).to(PhotoJDBCDAO.class);
        bind(FilterDAO.class).to(FilterJDBCDAO.class);

    }

}
