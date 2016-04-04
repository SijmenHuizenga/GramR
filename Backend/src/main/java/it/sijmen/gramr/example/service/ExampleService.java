package it.sijmen.gramr.example.service;

import com.google.inject.Inject;
import it.sijmen.gramr.common.pojo.ExamplePojo;
import it.sijmen.gramr.example.data.ExampleDAO;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class ExampleService {

    private ExampleDAO exDao;
    private Random random;

    @Inject
    public ExampleService(ExampleDAO dao, Random random){
        this.exDao = dao;
        this.random = random;
    }

    public String getData(){
        ExamplePojo dataObj;
        try {
            dataObj = exDao.getData();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        String[] parts = dataObj.getData();
        return parts[random.nextInt(parts.length)];
    }

}
