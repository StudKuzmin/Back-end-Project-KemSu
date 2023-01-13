package classes.controller.controller;

import classes.controller.controllerLogic.ControllerLogic;
import classes.model.model.Model;
import classes.model.requestsModel.UserModel;
import classes.controller.entity.EUser;

import java.util.ArrayList;
import java.util.List;


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

    public List<EUser> userGetList(String accessToken) throws Exception{
        EUser euser;
        boolean accessTokenIsOk = false;
        List<EUser> userList;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            userList = userModel.getUserList();
        }
        else throw new Exception();

        return userList;
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
