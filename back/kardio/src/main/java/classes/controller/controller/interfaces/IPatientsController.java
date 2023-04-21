package classes.controller.controller.interfaces;

import classes.database.entity.EPatient;

import java.util.List;

public interface IPatientsController {
    public List<EPatient> getPatientList(String accessToken) throws Exception;
    public EPatient createPatient(String accessToken, String patientDataJSON) throws Exception;
    public EPatient getOnePatient(String accessToken, String patientId) throws Exception;
    public EPatient deleteOnePatient(String accessToken, String patientId) throws Exception;
    public EPatient updateOnePatient(String accessToken, String patiendId, String patientDataJSON) throws Exception;

}
