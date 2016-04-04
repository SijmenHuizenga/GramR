package it.sijmen.gramr.example.data.daos;

import com.google.inject.Inject;
import it.sijmen.gramr.data.jdbc.JdbcDAO;
import it.sijmen.gramr.data.jdbc.JdbcDatabaseConnectionFactory;
import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.data.ExampleDAO;

import javax.annotation.Nullable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sijmen on 3-4-2016.
 */
public class ExampleJDBCDAO extends JdbcDAO implements ExampleDAO {

    @Inject
    public ExampleJDBCDAO(@Nullable JdbcDatabaseConnectionFactory connection) {
        super(connection);
    }

    @Override
    public ArrayList<ExamplePojo> getAllPojos() throws IOException {
        Connection connection;
        try {
            connection = getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ExampleTable");
            ResultSet set = statement.executeQuery();

            ArrayList<ExamplePojo> pojos = new ArrayList<>();

            while(set.next()){
                pojos.add(new ExamplePojo(set.getInt("id"), set.getString("data")));
            }
            set.close();
            statement.close();
            return pojos;
        } catch (IOException | SQLException e) {
            throw new IOException("Kon POJO niet ophalen uit de database: " + e.getMessage(), e);
        }
    }

}
