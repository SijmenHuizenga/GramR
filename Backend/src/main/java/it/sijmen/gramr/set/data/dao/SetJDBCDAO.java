package it.sijmen.gramr.set.data.dao;

import it.sijmen.gramr.common.pojo.PhotoPrivacy;
import it.sijmen.gramr.common.pojo.Set;
import it.sijmen.gramr.common.data.jdbc.JdbcDAO;
import it.sijmen.gramr.set.data.SetDAO;

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

    @Override
    public Set getSet(String setName) throws IOException {
        Connection connection;
        try {
            connection = getConnection();

            //todo: prepared statement
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `Set` WHERE `name` = '"+setName+"'");
            ResultSet set = statement.executeQuery();

            while(set.next())
                return new Set(set.getString("owner"), set.getString("name"));

            set.close();
            statement.close();
        } catch (IOException | SQLException e) {
            throw new IOException("Kon POJO niet ophalen uit de database: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void deletePhotoFromSet(String setName, int photoId) throws IOException {
        Connection connection;
        try {
            connection = getConnection();

            //todo: prepared statement
            PreparedStatement statement = connection.prepareStatement("DELETE FROM PhotoPrivacy WHERE set_name = '" + setName + "' AND photo_id = '" + photoId + "'");
            statement.executeUpdate();
            statement.close();
        } catch (IOException | SQLException e) {
            throw new IOException("Kon POJO niet verwijderen uit de database: " + e.getMessage(), e);
        }
    }

    @Override
    public void savePhotoPrivacyInSet(String setName, PhotoPrivacy photo) throws IOException {
        this.deletePhotoFromSet(setName, photo.getPhoto().getId());

        Connection connection;
        try {
            connection = getConnection();

            //todo: prepared statement
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `GramR`.`PhotoPrivacy` (`set_name`, `photo_id`, `open`) VALUES ('"+setName+"', '"+photo.getPhoto().getId()+"', "+photo.isOpen()+");");
            statement.executeUpdate();
            statement.close();
        } catch (IOException | SQLException e) {
            throw new IOException("Kon POJO niet opslaan in de database: " + e.getMessage(), e);
        }
    }

}
