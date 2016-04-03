package it.sijmen.gramr.example.data.daos;

import com.google.inject.Inject;
import it.sijmen.gramr.example.data.DAO;
import it.sijmen.gramr.example.data.ExampleDAO;

import javax.annotation.Nullable;
import javax.inject.Named;
import java.sql.Connection;
import java.util.Random;

/**
 * Created by Sinius on 3-4-2016.
 */
public class ExampleJDBCDAO extends DAO implements ExampleDAO {

    private Random random;
    private String data;

    @Inject
    public ExampleJDBCDAO(@Named("HelloWorldTxt") String data, Random random, @Nullable Connection connection) {
        super(connection);
        this.data = data;
        this.random = random;
    }

    public String getData() {
        return random.nextInt(100) + this.data;
    }

}
