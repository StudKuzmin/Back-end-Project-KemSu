package classes.controller.controllerLogic;

import classes.database.entity.EPatient;
import classes.database.entity.EUser;

public interface IControllerLogic {
    public EUser getUserDataWithToken(String token) throws Exception;
    public boolean checkToken(String token, String issuer);
    public String getUserToken(int userId, String role) throws Exception;
    public EPatient fromPatientJson(String patientDataJSON);
    public EUser fromUserJson(String userDataJSON);

}
