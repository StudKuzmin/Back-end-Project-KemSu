package classes.controller.controllerLogic;

import classes.controller.jwt.IJsonWebToken;
import classes.controller.jwt.JsonWebToken;
import classes.database.entity.EPatient;
import classes.database.entity.EToken;
import classes.database.entity.EUser;
import com.google.gson.Gson;
import jakarta.inject.Inject;

public class ControllerLogic implements IControllerLogic{
    @Inject
    IJsonWebToken jwt;

    public EUser getUserDataWithToken(String token) throws Exception{
        EUser euser = new EUser(); // TODO DELETE DEPENDENCE
//        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE

        euser.id = Integer.parseInt(jwt.getClaimFromToken(token, "id"));
        euser.role = jwt.getClaimFromToken(token, "role");

        return euser;
    }
    public boolean checkToken(String token, String issuer){
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE
        return jwt.checkToken(token, issuer);
    }

    public String getUserToken(int userId, String role) throws Exception {
        EToken etoken = new EToken(); // TODO DELETE DEPENDENCE
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE
        Gson gson = new Gson();

        try {
            etoken.accessToken = jwt.generateToken(userId, "accessToken", role);
            etoken.refreshToken = jwt.generateToken(userId, "refreshToken", role);
        }
        catch(Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("token generation error");
        }

        return gson.toJson(etoken);
    }

    public EPatient fromPatientJson(String patientDataJSON){
        EPatient epatient = new EPatient();
        Gson gson = new Gson();

        try {
            epatient = gson.fromJson(patientDataJSON, EPatient.class);
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
}
