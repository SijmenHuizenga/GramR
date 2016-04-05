package it.sijmen.gramr.photo.data.dao;

import com.google.inject.Inject;
import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.common.pojo.Photo;
import it.sijmen.gramr.common.pojo.PhotoPrivacy;
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
import java.util.ArrayList;

/**
 * Created by Sijmen on 5-4-2016.
 */
public class PhotoJDBCDAO extends JdbcDAO implements PhotoDAO {

    @Inject
    public PhotoJDBCDAO(@Nullable JdbcDatabaseConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    @Override
    public ArrayList<PhotoPrivacy> getPhotosBySet(String setName) throws IOException {
        ArrayList<PhotoPrivacy> out = new ArrayList<>();

        Connection connection;
        try {
            connection = getConnection();

            //todo: prepared statements want dit is lelijk
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Photo LEFT JOIN PhotoPrivacy ON Photo.id = PhotoPrivacy.photo_id WHERE PhotoPrivacy.set_name = '" + setName + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                out.add(new PhotoPrivacy(new Photo(
                        resultSet.getInt("id"),
                        resultSet.getString("creator"),
                        resultSet.getString("title"),
                        resultSet.getString("url"),
                        resultSet.getString("description"),
                        null
                ), resultSet.getBoolean("open")));
            }
            resultSet.close();
            statement.close();
        } catch (IOException | SQLException e) {
            throw new IOException("Kon POJO niet ophalen uit de database: " + e.getMessage(), e);
        }

        return out;
    }

    @Override
    public Photo getPhoto(int id) throws IOException {
        Connection connection;
        try {
            connection = getConnection();

            //todo: prepared statements want dit is lelijk
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Photo WHERE id = '" + id + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                return new Photo(
                        resultSet.getInt("id"),
                        resultSet.getString("creator"),
                        resultSet.getString("title"),
                        resultSet.getString("url"),
                        resultSet.getString("description"),
                        null
                );
            }
            resultSet.close();
            statement.close();
        } catch (IOException | SQLException e) {
            throw new IOException("Kon POJO niet ophalen uit de database: " + e.getMessage(), e);
        }
        return null;
    }
}
