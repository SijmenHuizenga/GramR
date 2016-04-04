package it.sijmen.gramr.photo.data.dao;

import com.google.inject.Inject;
import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.common.pojo.Photo;
import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.data.jdbc.JdbcDAO;
import it.sijmen.gramr.data.jdbc.JdbcDatabaseConnectionFactory;
import it.sijmen.gramr.photo.data.PhotoDAO;

import javax.annotation.Nullable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sijmen on 5-4-2016.
 */
public class PhotoJDBCDAO extends JdbcDAO implements PhotoDAO {

    @Inject
    public PhotoJDBCDAO(@Nullable JdbcDatabaseConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    @Override
    public void fillPhotosInSet(Set set) throws IOException {
        Connection connection;
        try {
            connection = getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Photo LEFT JOIN PhotoPrivacy ON Photo.id = PhotoPrivacy.photo_id WHERE PhotoPrivacy.set_name = '" + set.getName() + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                set.addPhoto(new Photo(
                        resultSet.getInt("id"),
                        resultSet.getString("creator"),
                        resultSet.getString("title"),
                        resultSet.getString("url"),
                        resultSet.getString("description"),
                        null
                ), resultSet.getBoolean("open"));
            }
            resultSet.close();
            statement.close();
        } catch (IOException | SQLException e) {
            throw new IOException("Kon POJO niet ophalen uit de database: " + e.getMessage(), e);
        }
    }
}
