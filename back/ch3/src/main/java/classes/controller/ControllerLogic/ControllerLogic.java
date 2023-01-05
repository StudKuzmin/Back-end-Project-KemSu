package classes.controller.ControllerLogic;

import classes.controller.jwt.JsonWebToken;
import classes.controller.entity.EToken;
import classes.controller.entity.EUser;
import com.google.gson.Gson;

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
    public EUser getUserDataFromJWT(String token) throws Exception{
        EUser euser = new EUser();
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE

        euser.login = jwt.getClaimFromToken(token, "login");
        euser.password = jwt.getClaimFromToken(token, "password");

        return euser;
    }
    public String userGetToken(String login, String password){
        EToken etoken = new EToken(); // TODO DELETE DEPENDENCE
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE

        etoken.accessToken = jwt.generateToken(login, password, "accessToken");
        etoken.refreshToken = jwt.generateToken(login, password, "refreshToken");

        return gson.toJson(etoken);
    }

    public boolean userCheckToken(String token, String issuer){
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE
        return jwt.checkToken(token, issuer);
    }
}
