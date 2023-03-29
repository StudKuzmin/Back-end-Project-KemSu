package classes.controller.controllerLogic;

import classes.controller.jwt.JsonWebToken;
import classes.database.entity.EPatient;
import classes.database.entity.EUser;
import classes.database.entity.EToken;

import com.google.gson.Gson;

public class ControllerLogic {
    private Gson gson;
    public ControllerLogic(){
        gson = new Gson();
    }

    public String jsonStringify(Object entity){
        return gson.toJson(entity);
    }

    public EUser userFromJson(String userDataJSON){
        EUser euser = new EUser();

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
    public EUser getUserDataWithToken(String token) throws Exception{
        EUser euser = new EUser(); // TODO DELETE DEPENDENCE
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE

        euser.id = Integer.parseInt(jwt.getClaimFromToken(token, "id"));
        euser.role = jwt.getClaimFromToken(token, "role");

        return euser;
    }
    public String getUserToken(int userId, String role) throws Exception {
        EToken etoken = new EToken(); // TODO DELETE DEPENDENCE
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE

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

    public boolean checkUserToken(String token, String issuer){
        JsonWebToken jwt = new JsonWebToken(); // TODO DELETE DEPENDENCE
        return jwt.checkToken(token, issuer);
    }

    public EPatient getPatientData(String patientDataJSON){
        EPatient epatient = new EPatient();

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
}
