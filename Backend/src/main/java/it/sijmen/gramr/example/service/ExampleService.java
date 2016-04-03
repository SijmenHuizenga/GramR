package it.sijmen.gramr.example.service;

import com.google.inject.Inject;
import it.sijmen.gramr.example.data.ExampleDAO;

import javax.inject.Named;
import java.util.Random;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class ExampleService {

    private ExampleDAO dao;

    @Inject
    public ExampleService(ExampleDAO dao){
        this.dao = dao;
    }

    public String getData(){
        //todo: add some dificult buisness logic
        return dao.getData();
    }

}
