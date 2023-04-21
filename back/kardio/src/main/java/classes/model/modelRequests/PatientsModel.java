package classes.model.modelRequests;

import classes.database.dbservice.IDBservice;
import classes.database.entity.EPatient;
import classes.model.modelLogic.IModelLogic;
import classes.model.modelRequests.interfaces.IPatientsModel;
import jakarta.inject.Inject;

import java.util.List;

public class PatientsModel implements IPatientsModel {
    @Inject
    IDBservice dbservice;
    @Inject
    IModelLogic modelLogic;

    public List<EPatient> getPatientList() throws Exception{
        String entity = "patients";
        try {
            // Достаём из БД данные
            List<EPatient> patientList = dbservice.selectPatients();

            // Расшифровка данных с БД
            List<EPatient> decryptedPatientList = modelLogic.getDecryptedPatientList(patientList);

            return decryptedPatientList;
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select");
        }
    }

    public boolean createPatient(EPatient epatient) throws Exception{
        try {
            EPatient encryptedPatient = modelLogic.getEncryptedPatient(epatient);

            return dbservice.insert(encryptedPatient);
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return false;
        }
    }

    public EPatient getOnePatient(String patientId) throws Exception{
        String entity = "patients";
        try {
            // Достаём из БД данные
            List<EPatient> patientList = dbservice.selectPatients();

            // Расшифровка данных с БД
            List<EPatient> decryptedPatientList = modelLogic.getDecryptedPatientList(patientList);

            for (EPatient e : decryptedPatientList) {
                if (patientId.equals(String.valueOf(e.id))) {
                    return e;
                }
            }
            throw new Exception("ID not found");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select");
        }
    }
    public EPatient deleteOnePatient(String patientId) throws Exception{
        String entity = "patients";
        try {
            // Достаём из БД данные
            List<EPatient> patientList = dbservice.selectPatients();

            // Расшифровка данных с БД
            List<EPatient> decryptedPatientList = modelLogic.getDecryptedPatientList(patientList);

            for(EPatient e: decryptedPatientList){
                if (patientId.equals(String.valueOf(e.id)))
                    if(dbservice.delete(entity, patientId)) {
                        return e;
                    }
            }
            throw new Exception("ID not found");
            // Мой код is shit, sorry
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select or delete");
        }
    }
    public EPatient updateOnePatient(String patientId, EPatient newPatientData) throws Exception{
        String entity = "patients";
        try {
            // Достаём из БД старые данные
            List<EPatient> patientList = dbservice.selectPatients();

            // Расшифровка старых данных с БД
            List<EPatient> decryptedPatientList = modelLogic.getDecryptedPatientList(patientList);

            // Шифровка новых данных для инсерта в БД
            EPatient newEncryptedPatientData = modelLogic.getEncryptedPatient(newPatientData);

            for(EPatient e: decryptedPatientList){
                if (patientId.equals(String.valueOf(e.id))){
                    boolean updated = dbservice.update("patients", patientId, newEncryptedPatientData);
                    if (updated)
                        return newPatientData;
                    throw new Exception("not updated");
                }
            }
            throw new Exception("ID not found");
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select or delete");
        }
    }
}
