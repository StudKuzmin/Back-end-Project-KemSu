package classes.controller.Controller;

import classes.controller.ControllerLogic.ControllerLogic;
import classes.model.Model.Model;
import classes.model.RequestsModel.UserModel;
import classes.controller.entity.EUser;
import com.google.gson.Gson;

import java.util.List;


public class Controller {
    private UserModel userModel;
    private ControllerLogic controllerLogic;
    private Model model;
    private Gson gson;

    public Controller(){
        userModel = new UserModel(); // TODO DELETE DEPENDENCE
        controllerLogic = new ControllerLogic(); // TODO DELETE DEPENDENCE
        gson = new Gson();
    }
    public String userLoginPost(String userDataJSON) throws Exception{
        boolean userDataIsOk;
        String token = "UNDEFINED";
        EUser euser;

        euser = controllerLogic.getUserData(userDataJSON);

        userDataIsOk = userModel.userLoginPost(euser.login, euser.password);
        if (userDataIsOk) {
            token = controllerLogic.userGetToken(euser.login, euser.password);
        }
        else throw new Exception();


        return token;
    }
    public String refreshToken(String refreshToken) throws Exception {
        String token = "UNDEFINED";
        boolean refreshTokenIsOk;

        refreshTokenIsOk = controllerLogic.userCheckToken(refreshToken, "refreshToken");

        if(refreshTokenIsOk) {
            token = controllerLogic.userGetToken(refreshToken);
            return token;
        }
        else {
            throw new Exception();
        }
    }
}
