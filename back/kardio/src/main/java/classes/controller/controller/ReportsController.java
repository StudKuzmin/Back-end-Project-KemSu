package classes.controller.controller;

import classes.controller.controller.interfaces.IReportsController;
import jakarta.inject.Inject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ReportsController implements IReportsController {
    public void test(){
//        try {
//            // GET
//            HttpClient client = HttpClient.newBuilder()
//                    .followRedirects(HttpClient.Redirect.ALWAYS)
//                    .build();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create("http://localhost:80/v1/plugins"))
//                    .header("Content-Type", "application/json")
////                    .POST(HttpRequest.BodyPublishers.ofString("{\"key\": \"value\"}"))
//                    .GET()
//                    .build();
//
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//            System.out.println("RESPONSE CODE: " + response.statusCode());
//            System.out.println("RESPONSE BODY GET: " + response.body());
//        }
//        catch (Exception ex){
//            System.out.printf("ERROR in %s.%s: %s%n",
//                    this.getClass(),
//                    new Throwable().getStackTrace()[0].getMethodName(),
//                    ex.getMessage());
//        }
        System.out.println("ReportsController");
    }

}
