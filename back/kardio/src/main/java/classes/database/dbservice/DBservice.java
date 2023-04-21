package classes.database.dbservice;

import classes.database.entity.EUser;
import classes.database.entity.EPatient;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.transaction.UserTransaction;

import java.util.*;

public class DBservice implements IDBservice{
    @Resource
    private UserTransaction userTransaction;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    public DBservice(){
        entityManagerFactory = Persistence.createEntityManagerFactory("dbkardiounit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public boolean insert(Object entity){
        try {
            userTransaction.begin();
            entityManager.joinTransaction();

            entityManager.persist(entity);
            userTransaction.commit();

            return true;
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return false;
        }
    }

    public List<EUser> selectUsers() throws Exception{
        try {
            String query = "users.findAll";

            userTransaction.begin();
            entityManager.joinTransaction();

            List<EUser> entityList = entityManager.createNamedQuery(query).getResultList();
            userTransaction.commit();

            return entityList;
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select");
        }
    }
    public List<EPatient> selectPatients() throws Exception{
        try {
            String query = "patients.findAll";

            userTransaction.begin();
            entityManager.joinTransaction();

            List<EPatient> entityList = entityManager.createNamedQuery(query).getResultList();
            userTransaction.commit();

            return entityList;
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select");
        }
    }

    public boolean delete(String entity, String entityId){
        try {
            userTransaction.begin();
            entityManager.joinTransaction();

            Query query = entityManager.createNativeQuery("DELETE FROM " + entity + " WHERE id = " + entityId);
            query.executeUpdate();

            userTransaction.commit();

            return true;
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return false;
    }

    public boolean update(String entity, String oldId, Object newEntityData){
        String action = "updateById";
        try {
            userTransaction.begin();
            entityManager.joinTransaction();

            switch(entity) {
                case "users":
                    EUser newUserData = (EUser)newEntityData;
                    entityManager.createNamedQuery(entity + "." + action)
                            .setParameter("id", newUserData.id)
                            .setParameter("registrationDate", newUserData.registrationDate)
                            .setParameter("fullName", newUserData.fullName)
                            .setParameter("login", newUserData.login)
                            .setParameter("password", newUserData.password)
                            .setParameter("role", newUserData.role)
                            .setParameter("status", newUserData.status)
                            .setParameter("deletionDate", newUserData.deletionDate)
                            .setParameter("id", Integer.valueOf(oldId))
                            .executeUpdate();

                    userTransaction.commit();
                    return true;
                case "patients":
                    EPatient newPatientData = (EPatient)newEntityData;
                    System.out.println("new id = " + newPatientData.id);
                    entityManager.createNamedQuery(entity + "." + action)
                            .setParameter("id", newPatientData.id)
                            .setParameter("dateOfAdmission", newPatientData.dateOfAdmission)
                            .setParameter("sex", newPatientData.sex)
                            .setParameter("age", newPatientData.age)
                            .setParameter("urea", newPatientData.urea)
                            .setParameter("creatinine", newPatientData.creatinine)
                            .setParameter("AST", newPatientData.AST)
                            .setParameter("ALT", newPatientData.ALT)
                            .setParameter("glucose", newPatientData.glucose)
                            .setParameter("leukocytes", newPatientData.leukocytes)
                            .setParameter("platelets", newPatientData.platelets)
                            .setParameter("neutrophils", newPatientData.neutrophils)
                            .setParameter("lymphocytes", newPatientData.lymphocytes)
                            .setParameter("DminusDimer", newPatientData.DminusDimer)
                            .setParameter("AG", newPatientData.AG)
                            .setParameter("SD", newPatientData.SD)
                            .setParameter("IBS", newPatientData.IBS)
                            .setParameter("HOBL", newPatientData.HOBL)
                            .setParameter("HBP", newPatientData.HBP)
                            .setParameter("CRP", newPatientData.CRP)
                            .setParameter("SKF", newPatientData.SKF)
                            .setParameter("neutrophilMinusLymphocyteRatio", newPatientData.neutrophilMinusLymphocyteRatio)
                            .setParameter("cabsType", newPatientData.cabsType)
                            .setParameter("BMI", newPatientData.BMI)
                            .setParameter("overweight", newPatientData.overweight)
                            .setParameter("smoking", newPatientData.smoking)
                            .setParameter("heredity", newPatientData.heredity)
                            .setParameter("dyslipidemia", newPatientData.dyslipidemia)
                            .setParameter("HOBLminusBA", newPatientData.HOBLminusBA)
                            .setParameter("PIKS", newPatientData.PIKS)
                            .setParameter("FP", newPatientData.FP)
                            .setParameter("SU", newPatientData.SU)
                            .setParameter("TH", newPatientData.TH)
                            .setParameter("varicose", newPatientData.varicose)
                            .setParameter("cardiacLesions", newPatientData.cardiacLesions)
                            .setParameter("LLALesions", newPatientData.LLALesions)
                            .setParameter("FCAnginaPectoris", newPatientData.FCAnginaPectoris)
                            .setParameter("FCCHF", newPatientData.FCCHF)
                            .setParameter("LVEF", newPatientData.LVEF)
                            .setParameter("ISs", newPatientData.ISs)
                            .setParameter("EuroScore2", newPatientData.EuroScore2)
                            .setParameter("IK", newPatientData.IK)
                            .setParameter("IKTime", newPatientData.IKTime)
                            .setParameter("aorticClampTime", newPatientData.aorticClampTime)
                            .setParameter("TminusBodies", newPatientData.TminusBodies)
                            .setParameter("numberOfCardioplegias", newPatientData.numberOfCardioplegias)
                            .setParameter("VPminusLZ", newPatientData.VPminusLZ)
                            .setParameter("revascularizationIndex", newPatientData.revascularizationIndex)
                            .setParameter("YminusTypeCOBS", newPatientData.YminusTypeCOBS)
                            .setParameter("LIMAExcretion", newPatientData.LIMAExcretion)
                            .setParameter("RIMAExcretion", newPatientData.RIMAExcretion)
                            .setParameter("LAUsage", newPatientData.LAUsage)
                            .setParameter("AVUsage", newPatientData.AVUsage)
                            .setParameter("bloodLoss", newPatientData.bloodLoss)
                            .setParameter("ALVTime", newPatientData.ALVTime)
                            .setParameter("inotropicSupport", newPatientData.inotropicSupport)
                            .setParameter("pneumonia", newPatientData.pneumonia)
                            .setParameter("SN", newPatientData.SN)
                            .setParameter("FPminusTP", newPatientData.FPminusTP)
                            .setParameter("pleuralEffusion", newPatientData.pleuralEffusion)
                            .setParameter("hydropericardium", newPatientData.hydropericardium)
                            .setParameter("pneumothorax", newPatientData.pneumothorax)
                            .setParameter("sternalComplications", newPatientData.sternalComplications)
                            .setParameter("AKK", newPatientData.AKK)
                            .setParameter("iAPF", newPatientData.iAPF)
                            .setParameter("spironolactone", newPatientData.spironolactone)
                            .setParameter("diuretics", newPatientData.diuretics)
                            .setParameter("cordaron", newPatientData.cordaron)
                            .setParameter("hospitalizationDuration", newPatientData.hospitalizationDuration)
                            .setParameter("CEAfteer", newPatientData.CEAfteer)
                            .setParameter("ANCOperationsAfter", newPatientData.ANCOperationsAfter)
                            .setParameter("antiplateletAgentsAfter", newPatientData.antiplateletAgentsAfter)
                            .setParameter("anticoagulants", newPatientData.anticoagulants)
                            .setParameter("BABAfter", newPatientData.BABAfter)
                            .setParameter("AKKAfter", newPatientData.AKKAfter)
                            .setParameter("iAPFAfter", newPatientData.iAPFAfter)
                            .setParameter("ARAAfter", newPatientData.ARAAfter)
                            .setParameter("diureticsAfter", newPatientData.diureticsAfter)
                            .setParameter("statins", newPatientData.statins)
                            .setParameter("heartAttack", newPatientData.heartAttack)
                            .setParameter("PCI", newPatientData.PCI)
                            .setParameter("insult", newPatientData.insult)
                            .setParameter("death", newPatientData.death)
                            .setParameter("id", Integer.valueOf(oldId))
                            .executeUpdate();

                    userTransaction.commit();
                    return true;
                default:
                    return false;
            }
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return false;
        }
    }
}
