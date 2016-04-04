package it.sijmen.gramr.common.data.jdbc;

import it.sijmen.gramr.common.data.DAO;

import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Sijmen on 4-4-2016.
 */
public class JdbcDAO extends DAO {

    private JdbcDatabaseConnectionFactory connectionFactory;

    public JdbcDAO(JdbcDatabaseConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    protected Connection getConnection() throws IOException {
        Connection connection = connectionFactory.get();
        if(connection == null)
            throw new IOException("Kon geen database-connectie openen.");
        return connection;
    }

}
