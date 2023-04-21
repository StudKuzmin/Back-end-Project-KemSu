package classes.controller.controller;

import classes.controller.controller.interfaces.IPatientsController;
import classes.controller.controllerLogic.IControllerLogic;
import classes.database.entity.EPatient;
import classes.model.modelRequests.interfaces.IPatientsModel;
import jakarta.inject.Inject;

import java.util.List;


public class PatientsController implements IPatientsController {
    @Inject
    IPatientsModel patientsModel;
    @Inject
    IControllerLogic controllerLogic;

    public List<EPatient> getPatientList(String accessToken) throws Exception{
        boolean accessTokenIsOk = false;
        List<EPatient> patientList;

        try {
            accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
            if (accessTokenIsOk) {
                patientList = patientsModel.getPatientList();
                return patientList;
            }
            else throw new Exception("BAD TOKEN");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception();
        }
    }
    public EPatient createPatient(String accessToken, String patientDataJSON) throws Exception{
        boolean accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            boolean patientCreated = false;
            try {
                EPatient epatient = controllerLogic.fromPatientJson(patientDataJSON);
                patientCreated = patientsModel.createPatient(epatient);
                if(patientCreated)
                    return epatient;
                throw new Exception("patient creation error");
            }
            catch (Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception();
            }
        }
        else throw new Exception("BAD TOKEN");
    }

    public EPatient getOnePatient(String accessToken, String patientId) throws Exception{
        boolean accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                EPatient epatient = patientsModel.getOnePatient(patientId);
                return epatient;
            }
            catch(Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception("some error");
            }
        }
        else throw new Exception("BAD TOKEN");
    }

    public EPatient deleteOnePatient(String accessToken, String patientId) throws Exception{
        boolean accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                return patientsModel.deleteOnePatient(patientId);
            }
            catch(Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception("ERROR while delete one user");
            }
        }
        else throw new Exception("BAD TOKEN");
    }
    public EPatient updateOnePatient(String accessToken, String patiendId, String patientDataJSON) throws Exception{
        boolean accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                EPatient newPatientData = controllerLogic.fromPatientJson(patientDataJSON);
                return patientsModel.updateOnePatient(patiendId, newPatientData);
            }
            catch(Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception("ERROR while update one user");
            }
        }
        else throw new Exception("BAD TOKEN");
    }
}
