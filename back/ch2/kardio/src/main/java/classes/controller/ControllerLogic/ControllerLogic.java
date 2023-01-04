package classes.controller.ControllerLogic;

import classes.controller.JWT.JsonWebToken;
import classes.controller.entity.EToken;
import classes.controller.entity.EUser;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class ControllerLogic {
    private Gson gson;
    public ControllerLogic(){
        gson = new Gson();
    }

    public EUser getUserData(String userDataJSON){
        EUser euser = new EUser();

        try {
            euser = gson.fromJson(userDataJSON, EUser.class);
        }
        catch (Exception e) {
            System.out.println("ERRROR in Controller.userCheckData: " + e.getMessage());
        }


        return euser;
    }
    public String userGetToken(String login, String password){
        EUser euser = new EUser(); // TODO DELETE DEPENDENCE
        EToken etoken = new EToken(); // TODO DELETE DEPENDENCE
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE

        etoken.accessToken = jwt.generateToken(euser.login, euser.password, "accessToken");
        etoken.refreshToken = jwt.generateToken(euser.login, euser.password, "refreshToken");

        return gson.toJson(etoken);
    }
    public String userGetToken(String refreshToken){
        EToken etoken = new EToken(); // TODO DELETE DEPENDENCE
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE

        etoken.accessToken = jwt.generateToken(refreshToken, "accessToken");
        etoken.refreshToken = jwt.generateToken(refreshToken, "refreshToken");

        return gson.toJson(etoken);
    }
    public boolean userCheckToken(String token, String issuer){
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE
        return jwt.checkToken(token, issuer);
    }
}
