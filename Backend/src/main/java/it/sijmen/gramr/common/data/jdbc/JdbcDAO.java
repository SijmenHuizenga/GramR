package it.sijmen.gramr.common.data.jdbc;

import com.google.inject.Inject;
import it.sijmen.gramr.common.data.AbstractDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Sijmen on 4-4-2016.
 */
public abstract class JdbcDAO extends AbstractDAO {

    @Inject
    private JdbcDatabaseConnectionFactory connectionFactory;

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
