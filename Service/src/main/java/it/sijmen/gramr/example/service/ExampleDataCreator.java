package it.sijmen.gramr.example.service;

import com.google.inject.Inject;

import javax.inject.Named;
import java.util.Random;

/**
 * Created by Sijmen on 2-4-2016.
 */
public class ExampleDataCreator {

    private Random random;
    private String data;

    @Inject
    public ExampleDataCreator(@Named("HelloWorldTxt") String data, Random random){
        this.data = data;
        this.random = random;
    }

    public String getData(){
        return this.generateData();
    }

    private String generateData(){
        return random.nextInt(100) + this.data;
    }

}
