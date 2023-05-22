package classes.model.modelRequests.interfaces;

import classes.database.entity.patient.EPatientCabs;
import classes.database.entity.patient.EPatientCovid;
import classes.database.entity.patient.EPatientCovidProperties;
import classes.database.entity.patient.EPatientPage;

import java.util.List;
import java.util.Map;

public interface IPatientsModel {
    public List<EPatientPage> getPatientList() throws Exception;
    public EPatientCovid createPatientCovid(EPatientCovid ePatientCovid) throws Exception;
    public EPatientCabs createPatientCabs(EPatientCabs ePatientCabs) throws Exception;
    public Map<String, String> getOnePatient(String patientId) throws Exception;
    public boolean deleteOnePatient(String patientId) throws Exception;
    public Map<String, String> updateOnePatient(String patientId, Map<String, String> newPatientData) throws Exception;

}
