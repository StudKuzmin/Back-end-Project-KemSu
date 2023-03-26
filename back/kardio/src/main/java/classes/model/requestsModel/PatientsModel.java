package classes.model.requestsModel;

import classes.database.DBservice;
import classes.database.entity.EPatient;
import classes.model.model.Model;
import jakarta.inject.Inject;

import java.util.List;

public class PatientsModel {
    @Inject
    DBservice dbservice;
    @Inject
    Model model;

    public List<EPatient> getPatientList() throws Exception{
        String entity = "patients";
        try {
            List<Object> objectList = dbservice.select(entity);
            List<EPatient> patientList = objectList.stream()
                    .map(element -> (EPatient)element).toList();

            return patientList;
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

            return dbservice.insert(epatient);
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
            List<Object> objectList = dbservice.select(entity);
            List<EPatient> patientList = objectList.stream()
                    .map(element -> (EPatient)element).toList();

            for (EPatient e : patientList) {
                if (patientId.equals(String.valueOf(e.id)))
                    return e;
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
            List<Object> objectList = dbservice.select(entity);
            List<EPatient> userList = objectList.stream()
                    .map(element -> (EPatient)element).toList();

            for(EPatient e: userList){
                if (patientId.equals(String.valueOf(e.id)))
                    if(dbservice.delete(entity, patientId))
                        return e;
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
            List<Object> objectList = dbservice.select(entity);
            List<EPatient> userList = objectList.stream()
                    .map(element -> (EPatient)element).toList();

            for(EPatient e: userList){
                if (patientId.equals(String.valueOf(e.id)))
                    if(dbservice.update(entity, patientId, newPatientData))
                        return e;
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
