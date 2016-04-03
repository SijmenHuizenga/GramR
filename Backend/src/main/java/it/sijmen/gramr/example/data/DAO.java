package it.sijmen.gramr.example.data;

import java.sql.Connection;

/**
 * Created by Sinius on 3-4-2016.
 */
public abstract class DAO {

    public DAO(Connection connection){
        System.out.println(connection);
        System.out.println("Im alive! and well");
    }

}
