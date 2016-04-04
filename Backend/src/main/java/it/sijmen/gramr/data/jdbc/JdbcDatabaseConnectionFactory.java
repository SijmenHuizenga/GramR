package it.sijmen.gramr.data.jdbc;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Sijmen on 3-4-2016.
 */
@Singleton
public class JdbcDatabaseConnectionFactory implements Provider<Connection> {

    private String connStr;
    private String driverClass;
    private String username;
    private String password;

    private boolean driverLoaded = false;
    private Connection connection = null;

    @Inject
    public JdbcDatabaseConnectionFactory(
            @Named("Jdbc Connection String") String connStr,
            @Named("Jdbc Driver Class String") String driverClass,
            @Named("Jdbc Connection Username String") String username,
            @Named("Jdbc Connection Password String") String password){
        this.connStr = connStr;
        this.driverClass = driverClass;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection get() {
        //kan niet throw doen omdat dit binnen een provider niet is toegestaan.
        if(!loadDriver())
            return null;
        if(hasConnectionCached()) {
            if(cacheConnectionIsOpen())
                return getCachedConnection();
        }
        Connection connection = createConnection();
        setCachedConnection(connection);
        return connection;
    }

    private boolean cacheConnectionIsOpen(){
        try {
            return !connection.isClosed() && connection.isValid(2);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean hasConnectionCached(){
        return connection != null;
    }

    private Connection getCachedConnection(){
        return this.connection;
    }

    public void setCachedConnection(Connection connection) {
        this.connection = connection;
    }

    private Connection createConnection(){
        Connection connection;
        System.out.println("Creating connection with: " + this.connStr);
        try {
            connection = DriverManager.getConnection(this.connStr, this.username, this.password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    private boolean loadDriver(){
        if(this.driverLoaded)
            return true;
        try {
            Class.forName(this.driverClass).newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
        this.driverLoaded = true;
        return true;
    }

}
