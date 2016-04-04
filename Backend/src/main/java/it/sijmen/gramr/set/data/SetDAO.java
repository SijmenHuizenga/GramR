package it.sijmen.gramr.set.data;

import it.sijmen.gramr.common.pojo.Set;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Sinius on 4-4-2016.
 */
public interface SetDAO {

    ArrayList<Set> getSetsByUser(String user) throws IOException;

}
