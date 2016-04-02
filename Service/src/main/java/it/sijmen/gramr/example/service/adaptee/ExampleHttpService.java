package it.sijmen.gramr.example.service.adaptee;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import it.sijmen.gramr.example.service.ExampleService;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * Created by Sijmen on 3-4-2016.
 * Dit voorbeeld is geïnspireerd door:
 * http://stackoverflow.com/a/3732328
 */
public class ExampleHttpService extends ExampleService implements HttpHandler{

    public ExampleHttpService() throws IOException {
        super();
        //todo: deze variabele dynamisch maken
        HttpServer server = HttpServer.create(new InetSocketAddress(1234), 0);
        server.createContext("/exampledata", this);
        server.setExecutor(null);
        server.start();
    }

    public static void main(String[] args) {
        try {
            new ExampleHttpService();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(500);
        }
    }

    public void handle(HttpExchange httpExchange) throws IOException {
        String response = this.getData();
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
