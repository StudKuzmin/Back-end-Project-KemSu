package classes.controller.controller;

import classes.controller.controllerLogic.ControllerLogic;
import classes.model.model.Model;
import classes.model.requestsModel.UserModel;
import classes.controller.entity.EUser;

import java.util.ArrayList;
import java.util.List;

//return euser.id + " " + euser.login + " " + euser.password + " " + euser.role + " " + euser.status + " " + euser.deletionDate + " " + euser.registrationDate + " " + euser.fullName;

public class Controller {
    private UserModel userModel;
    private ControllerLogic controllerLogic;


    public Controller(){
        userModel = new UserModel(); // TODO DELETE DEPENDENCE
        controllerLogic = new ControllerLogic(); // TODO DELETE DEPENDENCE
    }
    public String userLoginPost(String userDataJSON) throws Exception{
        boolean userDataIsOk;
        String token;
        EUser euser;

        euser = controllerLogic.getUserData(userDataJSON);

        userDataIsOk = userModel.userLoginPost(euser.login, euser.password);
        if (userDataIsOk) {
            token = controllerLogic.getUserToken(euser.login, euser.password, "user");
        }
        else throw new Exception();


        return token;
    }

    public List<EUser> getUserList(String accessToken) throws Exception{
        boolean accessTokenIsOk = false;
        List<EUser> userList;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            userList = userModel.getUserList();
        }
        else throw new Exception();

        return userList;
    }
    public List<String> createUser(String accessToken, String userDataJSON) throws Exception{
        EUser euser;
        boolean accessTokenIsOk = false;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");

        if(accessTokenIsOk){
            boolean userCreated = false;


            try {
                euser = controllerLogic.getUserData(userDataJSON);
                List<String> userData = userModel.createUser(euser);
                return userData;
            }
            catch (Exception ex){
                System.out.println("ERROR in Controller.createUser: " + ex);
                throw new Exception();
            }
        }
        else throw new Exception();
    }
    public String refreshToken(String refreshToken) throws Exception {
        String token;
        EUser euser;

        boolean refreshTokenIsOk;

        refreshTokenIsOk = controllerLogic.checkUserToken(refreshToken, "refreshToken");

        if(refreshTokenIsOk) {
            euser = controllerLogic.getUserDataWithToken(refreshToken);


            token = controllerLogic.getUserToken(euser.login, euser.password, euser.role);
            return token;
        }
        else {
            throw new Exception();
        }
    }
}
