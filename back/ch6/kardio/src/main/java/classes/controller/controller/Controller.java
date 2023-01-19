package classes.controller.controller;

import classes.controller.controllerLogic.ControllerLogic;
import classes.controller.entity.EPatient;
import classes.model.requestsModel.PatientModel;
import classes.model.requestsModel.UserModel;
import classes.controller.entity.EUser;

import java.util.List;

//return euser.id + " " + euser.login + " " + euser.password + " " + euser.role + " " + euser.status + " " + euser.deletionDate + " " + euser.registrationDate + " " + euser.fullName;

public class Controller {
    private UserModel userModel;
    private PatientModel patientModel;
    private ControllerLogic controllerLogic;


    public Controller(){
        userModel = new UserModel(); // TODO DELETE DEPENDENCE
        patientModel = new PatientModel(); // TODO DELETE DEPENDENCE
        controllerLogic = new ControllerLogic(); // TODO DELETE DEPENDENCE
    }
    public String userLoginPost(String userDataJSON) throws Exception{
        boolean userDataIsOk;
        String token;
        EUser euser;

        euser = controllerLogic.getUserData(userDataJSON);
        userDataIsOk = userModel.userLoginPost(euser.getLogin(), euser.getPassword());
        if (userDataIsOk) {
            token = controllerLogic.getUserToken(euser.getLogin(), euser.getPassword(), "user");
        }
        else throw new Exception("BAD USER DATA");


        return token;
    }
    public List<EUser> getUserList(String accessToken) throws Exception{
        boolean accessTokenIsOk = false;
        List<EUser> userList;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            userList = userModel.getUserList();
        }
        else throw new Exception("BAD TOKEN");

        return userList;
    }
    public EUser getOneUser(String accessToken, String userId) throws Exception{
        boolean accessTokenIsOk = false;
        EUser euser;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                euser = userModel.getOneUser(userId);
            }
            catch(Exception ex){
                System.out.println("ERROR in Controller.getOneUser: " + ex);
                throw new Exception();
            }
        }
        else throw new Exception("BAD TOKEN");

        return euser;
    }
    public EUser deleteOneUser(String accessToken, String userId) throws Exception{
        boolean accessTokenIsOk = false;
        EUser euser;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                euser = userModel.deleteOneUser(userId);
            }
            catch(Exception ex){
                System.out.println("ERROR in Controller.deleteOneUser: " + ex);
                throw new Exception();
            }
        }
        else throw new Exception("BAD TOKEN");

        return euser;
    }
    public EUser updateOneUser(String accessToken, String userId, String userDataJSON) throws Exception{
        boolean accessTokenIsOk = false;
        EUser euser;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                EUser newDataUser = controllerLogic.getUserData(userDataJSON);
                euser = userModel.updateOneUser(userId, newDataUser);
            }
            catch(Exception ex){
                System.out.println("ERROR in Controller.updateOneUser: " + ex);
                throw new Exception();
            }
        }
        else throw new Exception("BAD TOKEN");

        return euser;
    }
    public EUser createUser(String accessToken, String userDataJSON) throws Exception{
        EUser euser;
        boolean accessTokenIsOk = false;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");

        if(accessTokenIsOk){
            boolean userCreated = false;


            try {
                euser = controllerLogic.getUserData(userDataJSON);
                userCreated = userModel.createUser(euser);
                if(userCreated)
                    return euser;
                throw new Exception("user creation error");
            }
            catch (Exception ex){
                System.out.println("ERROR in Controller.createUser: " + ex);
                throw new Exception();
            }
        }
        else throw new Exception("BAD TOKEN");
    }
    public String refreshToken(String refreshToken) throws Exception {
        String token;
        EUser euser;

        boolean refreshTokenIsOk;

        refreshTokenIsOk = controllerLogic.checkUserToken(refreshToken, "refreshToken");

        if(refreshTokenIsOk) {
            euser = controllerLogic.getUserDataWithToken(refreshToken);
            try {
                token = controllerLogic.getUserToken(euser.getLogin(), euser.getPassword(), euser.getRole());
            }
            catch (Exception ex){
                System.out.println("ERROR in Controller.refreshToken: " + ex);
                throw new Exception("token get error");
            }
            return token;
        }
        else throw new Exception("BAD TOKEN");

    }

    public List<EPatient> getPatientList(String accessToken) throws Exception{
        boolean accessTokenIsOk = false;
        List<EPatient> patientList;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            patientList = patientModel.getPatientList();
        }
        else throw new Exception("BAD TOKEN");

        return patientList;
    }

    public EPatient createPatient(String accessToken, String patientDataJSON) throws Exception{
        EPatient epatient;
        boolean accessTokenIsOk = false;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            boolean patientCreated = false;
            try {
                epatient = controllerLogic.getPatientData(patientDataJSON);
                patientCreated = patientModel.createPatient(epatient);
                if(patientCreated)
                    return epatient;
                throw new Exception("patient creation error");
            }
            catch (Exception ex){
                System.out.println("ERROR in Controller.createPatient: " + ex);
                throw new Exception();
            }
        }
        else throw new Exception("BAD TOKEN");
    }

    public EPatient getOnePatient(String accessToken, String patientId) throws Exception{
        boolean accessTokenIsOk = false;
        EPatient epatient;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                epatient = patientModel.getOnePatient(patientId);
            }
            catch(Exception ex){
                System.out.println("ERROR in Controller.getOnePatient: " + ex);
                throw new Exception();
            }
        }
        else throw new Exception("BAD TOKEN");

        return epatient;
    }

    public EPatient deleteOnePatient(String accessToken, String patientId) throws Exception{
        boolean accessTokenIsOk = false;
        EPatient epatient;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                epatient = patientModel.deleteOnePatient(patientId);
            }
            catch(Exception ex){
                System.out.println("ERROR in Controller.deleteOnePatient: " + ex);
                throw new Exception();
            }
        }
        else throw new Exception("BAD TOKEN");

        return epatient;
    }
    public EPatient updateOnePatient(String accessToken, String patiendId, String patientDataJSON) throws Exception{
        boolean accessTokenIsOk = false;
        EPatient epatient;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                EPatient newPatientData = controllerLogic.getPatientData(patientDataJSON);
                epatient = patientModel.updateOnePatient(patiendId, newPatientData);
            }
            catch(Exception ex){
                System.out.println("ERROR in Controller.updateOnePatient: " + ex);
                throw new Exception();
            }
        }
        else throw new Exception("BAD TOKEN");

        return epatient;
    }
}
