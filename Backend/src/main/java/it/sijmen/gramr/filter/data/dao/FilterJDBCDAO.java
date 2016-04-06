package it.sijmen.gramr.filter.data.dao;

import com.google.inject.Inject;
import it.sijmen.gramr.common.pojo.Filter;
import it.sijmen.gramr.common.pojo.filters.*;
import it.sijmen.gramr.common.data.jdbc.JdbcDAO;
import it.sijmen.gramr.common.data.jdbc.JdbcDatabaseConnectionFactory;
import it.sijmen.gramr.filter.data.FilterDAO;

import javax.annotation.Nullable;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sijmen on 5-4-2016.
 */
public class FilterJDBCDAO extends JdbcDAO implements FilterDAO {

    @Override
    public Filter getPhotoFilter(int photoId) throws IOException {
        try {
            Filter filter = this.findGrayFilter(photoId);
            if(filter != null)
                return filter;
            return this.findVintageFilter(photoId);
        } catch (IOException | SQLException e) {
            throw new IOException("Kon POJO niet ophalen uit de database: " + e.getMessage(), e);
        }
    }

    /**
     * Zoekt een GrayFilter bij een bepaald PhotoID. Geeft NULL als niks gevonden.
     */
    private GrayFilter findGrayFilter(int photoId) throws IOException, SQLException {
        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM GrayFilter WHERE photo_id = '"+photoId+"'");
        ResultSet resultSet = statement.executeQuery();
        GrayFilter filter = null;
        if(resultSet.next())
            filter = new GrayFilter(resultSet.getInt("percentage"));

        resultSet.close();
        statement.close();
        return filter;
    }

    /**
     * Zoekt een VintageFilter bij een bepaald PhotoID. Geeft NULL als niks gevonden.
     */
    private VintageFilter findVintageFilter(int photoId) throws IOException, SQLException {
        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM VintageFilter WHERE photo_id = '"+photoId+"'");
        ResultSet resultSet = statement.executeQuery();
        VintageFilter filter = null;
        if(resultSet.next())
            filter = new VintageFilter(
                resultSet.getInt("upperLeftX"),
                resultSet.getInt("upperLeftY"),
                resultSet.getInt("lowerRightX"),
                resultSet.getInt("lowerRightY")
        );

        resultSet.close();
        statement.close();
        return filter;
    }

    @Override
    public void setPhotoFilter(int photoId, Filter filter) throws IOException {
        try {
            deleteFilters(photoId);
            if(filter == null)
                return;

            saveFilter(photoId, filter);
        } catch (IOException | SQLException e) {
            throw new IOException("Kon POJO niet ophalen uit de database: " + e.getMessage(), e);
        }
    }

    /**
     * Slaat een filter op bij een bepaald photoId.
     */
    private void saveFilter(int photoId, Filter filter) throws SQLException, IOException {
        if(filter instanceof VintageFilter)
            saveVintageFilter(photoId, (VintageFilter)filter);
        else if(filter instanceof GrayFilter)
            saveGrayFilter(photoId, (GrayFilter)filter);
        else
            throw new IOException("Unsported Filter type.");
    }

    /**
     * Verwijderd een Filter bij een bepaald photoID
     */
    private void deleteFilters(int photoId) throws SQLException, IOException {
        doUpdate("DELETE FROM VintageFilter where photo_id = " + photoId);
        doUpdate("DELETE FROM GrayFilter where photo_id = " + photoId);
    }

    /**
     * Slaat een VintageFilter op bij een bepaald photoId.
     */
    private void saveVintageFilter(int photoId, VintageFilter vintageFilter) throws SQLException, IOException {
        doUpdate("INSERT INTO `GramR`.`VintageFilter` (`photo_id`, `upperLeftX`, `upperLeftY`, `lowerRightX`, `lowerRightY`) " +
                "VALUES ('"+photoId+"', '"+vintageFilter.getUpperLeftX()+"', '"+vintageFilter.getUpperLeftX()+"', '"+vintageFilter.getLowerRightX()+"', '"+vintageFilter.getLowerRightY()+"')");

    }

    /**
     * Slaat een GrayFilter op bij een bepaald photoId.
     */
    private void saveGrayFilter(int photoId, GrayFilter grayFilter) throws SQLException, IOException {
        doUpdate("INSERT INTO `GramR`.`GrayFilter` (`photo_id`, `percentage`) VALUES ('"+photoId+"', '"+grayFilter.getPrecentage()+"')");
    }
}
