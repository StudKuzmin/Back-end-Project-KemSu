package classes.controller.controller;

import classes.controller.controller.interfaces.IPatientsController;
import classes.controller.controllerLogic.IControllerLogic;
import classes.controller.jwt.JsonWebToken;
import classes.database.entity.mopatientcovid.EPatientCabsBodyMO;
import classes.database.entity.mopatientcovid.EPatientCabsMO;
import classes.database.entity.mopatientcovid.EPatientCovidBodyMO;
import classes.database.entity.mopatientcovid.EPatientCovidMO;
import classes.database.entity.patient.*;
import classes.database.entity.user.EUser;
import classes.model.modelRequests.interfaces.IPatientsModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PatientsController implements IPatientsController {
    @Inject
    IPatientsModel patientsModel;
    @Inject
    IControllerLogic controllerLogic;

    public List<EPatientPage> getPatients(String accessToken, String type) throws Exception{
        boolean accessTokenIsOk = false;
        try {
            accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
            if (accessTokenIsOk) {
                Gson gson = new Gson();
                String userid = new JsonWebToken().getClaimFromToken(accessToken, "id");

//                Map<String, String> patientList = patientsModel.getPatientList();
                return patientsModel.getPatientList(userid, type);


            }
            else throw new Exception("BAD TOKEN");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception();
        }
    }
    public Map<String, String> postPatients(String accessToken, String patientDataJSON) throws Exception{
        boolean accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            boolean patientCreated = false;
            try {
                Gson gson = new Gson();
                ObjectMapper objectMapper = new ObjectMapper();

                String patientType = gson.fromJson(patientDataJSON, Map.class).get("type").toString();

                if (patientType.equals("covid")){
                    EPatientCovid ePatientCovid = new EPatientCovid();
                    Object covidDataobject = gson.fromJson(patientDataJSON, Map.class).get("properties");
                    ePatientCovid = gson.fromJson(patientDataJSON, EPatientCovid.class);

                    List<EPatientCovidBodyMO> ePatientCovidBodyMO = new ArrayList<>();
                    ePatientCovidBodyMO.add(new EPatientCovidBodyMO());
                    ePatientCovidBodyMO.get(0).sample = objectMapper.convertValue(covidDataobject, EPatientCovidMO.class);
                    String patientCovidData = gson.toJson(ePatientCovidBodyMO);

                    ePatientCovid.properties.survived = controllerLogic.predictCovid(patientCovidData);

                    ePatientCovid.userid = new JsonWebToken().getClaimFromToken(accessToken, "id");
                    ePatientCovid = patientsModel.createPatientCovid(ePatientCovid);
                    return gson.fromJson(gson.toJson(ePatientCovid), new HashMap<>().getClass());
                }

                if (patientType.equals("cabs")){
                    EPatientCabs ePatientCabs = new EPatientCabs();
                    Object cabsDataobject = gson.fromJson(patientDataJSON, Map.class).get("properties");
                    ePatientCabs = gson.fromJson(patientDataJSON, EPatientCabs.class);

                    List<EPatientCabsBodyMO> ePatientCabsBodyMO = new ArrayList<>();
                    ePatientCabsBodyMO.add(new EPatientCabsBodyMO());
                    ePatientCabsBodyMO.get(0).sample = objectMapper.convertValue(cabsDataobject, EPatientCabsMO.class);
                    String patientCabsData = gson.toJson(ePatientCabsBodyMO);

                    Map<String, String> map = controllerLogic.predictCabs(patientCabsData);
                    ePatientCabs.properties.MI = objectMapper.convertValue(map.get("contents"), EPatientCabsProperties[].class)[0].MI;
                    ePatientCabs.properties.CI = objectMapper.convertValue(map.get("contents"), EPatientCabsProperties[].class)[0].CI;
                    ePatientCabs.properties.insultOutcome = objectMapper.convertValue(map.get("contents"), EPatientCabsProperties[].class)[0].insultOutcome;
                    ePatientCabs.properties.death = objectMapper.convertValue(map.get("contents"), EPatientCabsProperties[].class)[0].death;
                    ePatientCabs.properties.comb = objectMapper.convertValue(map.get("contents"), EPatientCabsProperties[].class)[0].comb;

                    ePatientCabs.userid = new JsonWebToken().getClaimFromToken(accessToken, "id");
                    ePatientCabs = patientsModel.createPatientCabs(ePatientCabs);
                    return gson.fromJson(gson.toJson(ePatientCabs), new HashMap<>().getClass());
                }

                throw new Exception("No type");
            }
            catch (Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception();
            }
        }
        else throw new Exception("BAD TOKEN");
    }

    public Map<String, String> getPatientsPatientid(String accessToken, String patientId) throws Exception{
        boolean accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                Gson gson = new Gson();

                String userid = new JsonWebToken().getClaimFromToken(accessToken, "id");
                Map<String, String> patientData = patientsModel.getOnePatient(patientId, userid);

                return patientData;
            }
            catch(Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception("some error");
            }
        }
        else throw new Exception("BAD TOKEN");
    }

    public void deletePatientsPatientid(String accessToken, String patientId) throws Exception{
        boolean accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                boolean deleted = patientsModel.deleteOnePatient(patientId);
                if(!deleted)
                    throw new Exception("not deteted");
            }
            catch(Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception("ERROR while delete one user");
            }
        }
        else throw new Exception("BAD TOKEN");
    }
    public Map<String, String> patchPatientsPatientid(String accessToken, String patientId, String patientDataJSON) throws Exception{
        boolean accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                Gson gson = new Gson();
                Map<String, String> newPatientData = gson.fromJson(patientDataJSON, Map.class);
                newPatientData.replace("id", patientId);
                return patientsModel.updateOnePatient(patientId, newPatientData);
            }
            catch(Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception("ERROR while update one user");
            }
        }
        else throw new Exception("BAD TOKEN");
    }
}
