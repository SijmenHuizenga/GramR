package it.sijmen.gramr.data.jdbc;

import it.sijmen.gramr.data.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    protected void doUpdate(String q) throws SQLException, IOException {
        PreparedStatement statement = getConnection().prepareStatement(q);
        statement.executeUpdate();
        statement.close();
    }

}
