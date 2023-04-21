package classes.model.modelRequests.interfaces;

import classes.database.entity.EPatient;

import java.util.List;

public interface IPatientsModel {
    public List<EPatient> getPatientList() throws Exception;
    public boolean createPatient(EPatient epatient) throws Exception;
    public EPatient getOnePatient(String patientId) throws Exception;
    public EPatient deleteOnePatient(String patientId) throws Exception;
    public EPatient updateOnePatient(String patientId, EPatient newPatientData) throws Exception;

}
