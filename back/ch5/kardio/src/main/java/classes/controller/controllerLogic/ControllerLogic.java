package classes.controller.controllerLogic;

import classes.controller.jwt.JsonWebToken;
import classes.controller.entity.EToken;
import classes.controller.entity.EUser;
import com.google.gson.Gson;

public class ControllerLogic {
    private Gson gson;
    public ControllerLogic(){
        gson = new Gson();
    }

    public String jsonStringify(Object entity){
        return gson.toJson(entity);
    }

    public EUser getUserData(String userDataJSON){
        EUser euser = new EUser();

        try {
            euser = gson.fromJson(userDataJSON, EUser.class);
        }
        catch (Exception ex) {
            System.out.println("ERROR in ControllerLogic.getUserData: " + ex);
        }

        return euser;
    }
    public EUser getUserDataWithToken(String token) throws Exception{
        EUser euser = new EUser(); // TODO DELETE DEPENDENCE
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE

        euser.login = jwt.getClaimFromToken(token, "login");
        euser.password = jwt.getClaimFromToken(token, "password");
        euser.role = jwt.getClaimFromToken(token, "role");

        return euser;
    }
    public String getUserToken(String login, String password, String role){
        EToken etoken = new EToken(); // TODO DELETE DEPENDENCE
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE

        etoken.accessToken = jwt.generateToken(login, password, "accessToken", role);
        etoken.refreshToken = jwt.generateToken(login, password, "refreshToken", role);

        return gson.toJson(etoken);
    }

    public boolean checkUserToken(String token, String issuer){
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE
        return jwt.checkToken(token, issuer);
    }
}
