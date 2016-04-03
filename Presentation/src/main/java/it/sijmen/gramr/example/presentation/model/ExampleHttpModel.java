package it.sijmen.gramr.example.presentation.model;

import it.sijmen.gramr.example.presentation.ExampleModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Sinius on 3-4-2016.
 */
public class ExampleHttpModel implements ExampleModel {

    public String getData() {
        try{
            return this.readDataFromUrl();
        } catch (IOException e) {
            e.printStackTrace();
            return "Could not receive data from service layer";
        }
    }

    private String readDataFromUrl() throws IOException {
        //todo: make more dynamic
        URL oracle = new URL("http://localhost:1234/exampledata");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String totalData = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            totalData += inputLine;
        in.close();
        return totalData;
    }
}
