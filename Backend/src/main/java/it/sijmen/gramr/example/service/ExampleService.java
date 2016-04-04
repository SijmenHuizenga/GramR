package it.sijmen.gramr.example.service;

import com.google.inject.Inject;
import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.data.ExampleDAO;
import it.sijmen.gramr.service.AbstractService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class ExampleService extends AbstractService {

    private ExampleDAO exDao;
    private Random random;

    @Inject
    public ExampleService(ExampleDAO dao, Random random){
        this.exDao = dao;
        this.random = random;
    }

    public ExamplePojo getData() throws IOException {
        ArrayList<ExamplePojo> dataObj = exDao.getAllPojos();
        return dataObj.get(random.nextInt(dataObj.size()));
    }

}
