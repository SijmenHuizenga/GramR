package it.sijmen.gramr.set.data.dao;

import com.google.inject.Inject;

import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.data.jdbc.JdbcDAO;
import it.sijmen.gramr.data.jdbc.JdbcDatabaseConnectionFactory;
import it.sijmen.gramr.set.data.SetDAO;

import javax.annotation.Nullable;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sinius on 4-4-2016.
 */
public class SetJDBCDAO extends JdbcDAO implements SetDAO {

    @Inject
    public SetJDBCDAO(@Nullable JdbcDatabaseConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    /**
     * Loads all the sets with the given owner.
     * This does NOT fill the Photo list within this set.
     */
    @Override
    public ArrayList<Set> getSetsByUser(String user) throws IOException {
        Connection connection;
        try {
            connection = getConnection();

            //todo: prepared statement
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `Set` WHERE owner = '"+user+"'");
            ResultSet set = statement.executeQuery();

            ArrayList<Set> sets = new ArrayList<>();

            while(set.next()){
                sets.add(new Set(set.getString("owner"), set.getString("name")));
            }
            set.close();
            statement.close();

            return sets;
        } catch (IOException | SQLException e) {
            throw new IOException("Kon POJO niet ophalen uit de database: " + e.getMessage(), e);
        }
    }
}
