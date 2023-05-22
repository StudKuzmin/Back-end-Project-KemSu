package classes.controller.controllerLogic;

import classes.controller.dataset.Dataset;
import classes.controller.jwt.IJsonWebToken;
import classes.controller.jwt.JsonWebToken;
import classes.database.entity.*;
import classes.database.entity.getdatasets.EGetDatasetContentsResult;
import classes.database.entity.getdatasets.EGetDatasetResult;
import classes.database.entity.mopatientcovid.EPatientCovidMO;
import classes.database.entity.mopatientcovid.EPatientCovidPredictResultContentsMO;
import classes.database.entity.mopatientcovid.EPatientCovidPredictResultMO;
import classes.database.entity.patient.EPatientCovid;
import classes.database.entity.postdatasets.EPostDatasetBody;
import classes.database.entity.postdatasets.EPostDatasetResult;
import classes.database.entity.postdatasetsiddata.EPostDatasetDataBody;
import classes.database.entity.postdatasetsiddata.EPostDatasetDataResult;
import classes.database.entity.user.EUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.inject.Inject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ControllerLogic implements IControllerLogic{
    @Inject
    IJsonWebToken jwt;

    public Map<String, String> toMap(String dataJson) throws Exception{
        Gson gson = new Gson();
        try{
            return gson.fromJson(dataJson, Map.class);
        }
        catch(Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("error while convert to map");
        }
    }
    public EUser getUserDataWithToken(String token, String userId) throws Exception{
        EUser euser = new EUser(); // TODO DELETE DEPENDENCE

        euser.id = jwt.getClaimFromToken(token, "id");

        return euser;
    }
    public boolean checkToken(String token, String issuer){
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE
        return jwt.checkToken(token, issuer);
    }

    public EToken getUserToken(String userId, String role) throws Exception {
        EToken etoken = new EToken(); // TODO DELETE DEPENDENCE
        Gson gson = new Gson();

        try {
            etoken.accessToken = jwt.generateToken(userId, "accessToken", role);
            etoken.refreshToken = jwt.generateToken(userId, "refreshToken", role);
            System.out.println("TOKEEEN: " + etoken.accessToken);
        }
        catch(Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("token generation error");
        }

        return etoken;
    }

    public EPatientCovid fromPatientJson(String patientDataJSON){
        EPatientCovid epatient = new EPatientCovid();
        Gson gson = new Gson();

        try {
            epatient = gson.fromJson(patientDataJSON, EPatientCovid.class);
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return epatient;
    }
    public EUser fromUserJson(String userDataJSON){
        EUser euser = new EUser();
        Gson gson = new Gson();

        try {
            euser = gson.fromJson(userDataJSON, EUser.class);
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return euser;
    }
    public EPassword fromPasswordJson(String passwordDataJSON){
        EPassword ePassword = new EPassword();
        Gson gson = new Gson();

        try {
            ePassword = gson.fromJson(passwordDataJSON, EPassword.class);
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return ePassword;
    }
    public EToken fromTokenJson(String tokenDataJSON){
        EToken eToken = new EToken();
        Gson gson = new Gson();

        try {
            eToken = gson.fromJson(tokenDataJSON, EToken.class);
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return eToken;
    }

    public EModelPage fromEModelContentJson(String modelPageDataJSON){
        EModelPage eModelPage = new EModelPage();
        Gson gson = new Gson();

        try {
            eModelPage = gson.fromJson(modelPageDataJSON, EModelPage.class);
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return eModelPage;
    }

    public EDataset fromDatasetJson(String datasetJSON){
        EDataset eDataset = new EDataset();
        Gson gson = new Gson();

        try {
            eDataset = gson.fromJson(datasetJSON, EDataset.class);
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return eDataset;
    }

    public void createDatasetCovid(){
        try {
            Gson gson = new Gson();

            String name = "datasetCovid";
            int trainingSteps = 10;
            List<String> pluginList = new ArrayList<>(List.of("CovidDecisionTree"));
            EPostDatasetBody ePostDatasetBody = new EPostDatasetBody(name, pluginList, "desc covid", trainingSteps);

            String uri = "http://localhost:80/v1/datasets/";
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(ePostDatasetBody)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            EPostDatasetResult ePostDatasetResult = gson.fromJson(response.body(), EPostDatasetResult.class);
            Dataset.datasetCovidId = ePostDatasetResult.id;
        }
        catch(Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }
    }
    public void createDatasetCabs(){
        try {
            Gson gson = new Gson();

            String name = "datasetCabs";
            int trainingSteps = 10;
            List<String> pluginList = new ArrayList<>(List.of("CabsDecisionTree"));
            EPostDatasetBody ePostDatasetBody = new EPostDatasetBody(name, pluginList, "desc cabs", trainingSteps);

            String uri = "http://localhost:80/v1/datasets/";
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(ePostDatasetBody)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            EPostDatasetResult ePostDatasetResult = gson.fromJson(response.body(), EPostDatasetResult.class);
            Dataset.datasetCabsId = ePostDatasetResult.id;
        }
        catch(Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }
    }

    public void fillDatasetCovid() throws Exception{
        try {
            Gson gson = new Gson();

            BufferedReader reader = new BufferedReader(
                    new FileReader("..\\covidData.json")
            );

            List<EPostDatasetDataBody> ePostDatasetDataBodyList = Arrays.stream(
                    gson.fromJson(reader, EPostDatasetDataBody[].class)
            ).toList();

            String uri = "http://localhost:80/v1/datasets/" + Dataset.datasetCovidId + "/data";
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(ePostDatasetDataBodyList)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            EPostDatasetDataResult ePostDatasetDataResult = gson.fromJson(response.body(), EPostDatasetDataResult.class);
        }
        catch(Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }
    }
    public void fillDatasetCabs() throws Exception{
        try {
            Gson gson = new Gson();

            BufferedReader reader = new BufferedReader(
                    new FileReader("..\\cabsData.json")
            );

            List<Map<String, String>> postDatasetCabsDataresult = gson.fromJson(reader, List.class);

            String uri = "http://localhost:80/v1/datasets/" + Dataset.datasetCabsId + "/data";
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(postDatasetCabsDataresult)))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch(Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }
    }

    public String predictCovid(String patientCovidData) throws Exception{
        try {
            Gson gson = new Gson();
            List<EGetDatasetContentsResult> eGetDatasetContentsResults = this.getDatasetList();
            String datasetId;
            if(eGetDatasetContentsResults.get(0).plugins.get(0).equals("CovidDecisionTree"))
                datasetId = eGetDatasetContentsResults.get(0).id;
            else{
                datasetId = eGetDatasetContentsResults.get(1).id;
            }

            String uri = "http://localhost:80/v1/datasets/" + datasetId + "/predict";
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(patientCovidData))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("RESPONSE BODY: " + response.body());
            EPatientCovidPredictResultMO ePatientCovidPredictResultMO = gson.fromJson(response.body(), EPatientCovidPredictResultMO.class);
            String survived = ePatientCovidPredictResultMO.contents.get(0).survived;


            return survived;
        }
        catch(Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("some error");
        }
    }
    public Map<String, String> predictCabs(String patientCabsData) throws Exception{
        try {
            Gson gson = new Gson();
            List<EGetDatasetContentsResult> eGetDatasetContentsResults = this.getDatasetList();
            String datasetId;
            if(eGetDatasetContentsResults.get(0).plugins.get(0).equals("CabsDecisionTree"))
                datasetId = eGetDatasetContentsResults.get(0).id;
            else{
                datasetId = eGetDatasetContentsResults.get(1).id;
            }

            String uri = "http://localhost:80/v1/datasets/" + datasetId + "/predict";
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(patientCabsData))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("patientCabsData:  " + patientCabsData);
            System.out.println("RESPONSE:  " + response.body());
            return gson.fromJson(response.body(), Map.class);
        }
        catch(Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("some error");
        }
    }
    public List<EGetDatasetContentsResult> getDatasetList() throws Exception{
        try {
            Gson gson = new Gson();

            String uri = "http://localhost:80/v1/datasets/";
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            EGetDatasetResult getDatasetResult = gson.fromJson(response.body(), EGetDatasetResult.class);

            return getDatasetResult.contents;
        }
        catch(Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("some error");
        }
    }
}
