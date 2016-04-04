package it.sijmen.gramr.example.data.daos;

import com.google.inject.Inject;
import it.sijmen.gramr.common.data.jdbc.JdbcDAO;
import it.sijmen.gramr.common.data.jdbc.JdbcDatabaseConnectionFactory;
import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.data.ExampleDAO;

import javax.annotation.Nullable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sinius on 3-4-2016.
 */
public class ExampleJDBCDAO extends JdbcDAO implements ExampleDAO {

    @Inject
    public ExampleJDBCDAO(@Nullable JdbcDatabaseConnectionFactory connection) {
        super(connection);
    }

    @Override
    public ExamplePojo getData() throws IOException {
        Connection connection;
        try {
            connection = getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ExampleTable");
            ResultSet set = statement.executeQuery();

            ExamplePojo output = new ExamplePojo();
            while(set.next()){
                output.addData(set.getString("data"));
            }
            set.close();
            statement.close();
            return output;
        } catch (IOException | SQLException e) {
            throw new IOException("Er is iets fout gegaan: " + e.getMessage(), e);
        }
    }

}
