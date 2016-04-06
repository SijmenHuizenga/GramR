package it.sijmen.gramr.common.service;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import it.sijmen.gramr.common.YAMLFile;
import it.sijmen.gramr.common.data.jdbc.JdbcDatabaseConnectionFactory;
import it.sijmen.gramr.example.data.ExampleDAO;
import it.sijmen.gramr.example.data.daos.ExampleJDBCDAO;
import it.sijmen.gramr.filter.data.FilterDAO;
import it.sijmen.gramr.filter.data.dao.FilterJDBCDAO;
import it.sijmen.gramr.photo.data.PhotoDAO;
import it.sijmen.gramr.photo.data.dao.PhotoJDBCDAO;
import it.sijmen.gramr.set.data.SetDAO;
import it.sijmen.gramr.set.data.dao.SetJDBCDAO;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;

/**
 * Created by Sijmen on 3-4-2016.
 */
public class GuiceInjectorModule extends AbstractModule {

    YAMLFile config;

    public GuiceInjectorModule(){
        loadConfig();
    }

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("Jdbc Driver Class String")).toInstance(config.getString("jdbc.driver"));
        bind(String.class).annotatedWith(Names.named("Jdbc Connection String")).toInstance(config.getString("jdbc.connectionstring"));
        bind(String.class).annotatedWith(Names.named("Jdbc Connection Username String")).toInstance(config.getString("jdbc.user"));
        bind(String.class).annotatedWith(Names.named("Jdbc Connection Password String")).toInstance(config.getString("jdbc.password"));

        bind(Connection.class).toProvider(JdbcDatabaseConnectionFactory.class);

        bind(ExampleDAO.class).to(ExampleJDBCDAO.class);
        bind(SetDAO.class).to(SetJDBCDAO.class);
        bind(PhotoDAO.class).to(PhotoJDBCDAO.class);
        bind(FilterDAO.class).to(FilterJDBCDAO.class);
    }

    private void loadConfig(){
        try {
            File file = getConfigFile();

            config = new YAMLFile(true);
            config.Load(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File getConfigFile() throws URISyntaxException {
        //todo: dit is lelijk en moet anders
        return new File("C:\\gramrconfig.yaml");
    }

}
