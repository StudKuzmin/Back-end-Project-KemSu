package classes.controller.controller.interfaces;

import classes.database.entity.patient.EPatientCovid;
import classes.database.entity.patient.EPatientPage;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

public interface IPatientsController {
    public List<EPatientPage> getPatients(String accessToken, String type) throws Exception;
    public Map<String, String> postPatients(String accessToken, String patientDataJSON) throws Exception;
    public Map<String, String> getPatientsPatientid(String accessToken, String patientId) throws Exception;
    public void deletePatientsPatientid(String accessToken, String patientId) throws Exception;
    public Map<String, String> patchPatientsPatientid(String accessToken, String patientId, String patientDataJSON) throws Exception;

}
