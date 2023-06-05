package classes.database.dbservice;

import classes.database.entity.patient.EPatientCabs;
import classes.database.entity.patient.EPatientCovidProperties;
import classes.database.entity.user.EUser;
import classes.database.entity.patient.EPatientCovid;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.transaction.*;

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
    public EUser selectUserById(String userId) throws Exception{
        try {
            String query = "users.findAll";

            userTransaction.begin();
            entityManager.joinTransaction();

            List<EUser> entityList = entityManager.createNamedQuery(query).getResultList();
            for (EUser e : entityList)
                if(userId.equals(e.id)){
                    userTransaction.commit();
                    return e;
                }
            throw new Exception("userId not found");
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select");
        }
    }
    public List<EPatientCovid> selectPatientsCovid() throws Exception{
        try {
            String query = "patientsCovid.findAll";

            userTransaction.begin();
            entityManager.joinTransaction();

            List<EPatientCovid> entityList = entityManager.createNamedQuery(query).getResultList();
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
    public List<Map<String, String>> selectPatientsCovidMAP() throws Exception{
        try {
            String query = "patientsCovid.findAll";

            userTransaction.begin();
            entityManager.joinTransaction();

            List<Map<String, String>> entityList = entityManager.createNamedQuery(query).getResultList();
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

    public List<EPatientCabs> selectPatientsCabs() throws Exception{
        try {
            String query = "patientsCabs.findAll";

            userTransaction.begin();
            entityManager.joinTransaction();

            List<EPatientCabs> entityList = entityManager.createNamedQuery(query).getResultList();
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

            Query query = entityManager.createNativeQuery("DELETE FROM " + entity + " WHERE id = \"" + entityId + "\"");
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

    public boolean updateUserInfo(EUser newUserData){
        String action = "updateById";
        try {
            userTransaction.begin();
            entityManager.joinTransaction();

            entityManager.createNamedQuery("users.updateById")
                    .setParameter("firstName", newUserData.firstName)
                    .setParameter("middleName", newUserData.middleName)
                    .setParameter("lastName", newUserData.lastName)
                    .setParameter("userName", newUserData.userName)
                    .setParameter("id", newUserData.id)
                    .executeUpdate();

            userTransaction.commit();
            return true;

            } catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return false;
        }
    }

    public boolean updatePatientCovid(EPatientCovid ePatientCovid){
        try {
            userTransaction.begin();
            entityManager.joinTransaction();

            EPatientCovid ep = entityManager.find(EPatientCovid.class, ePatientCovid.id);
            ep.description = ePatientCovid.description;
            ep.properties = ePatientCovid.properties;


            userTransaction.commit();
            return true;

        } catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return false;
        }
    }
    public boolean updateUserPassword(EUser newUserData){
        try {
            userTransaction.begin();
            entityManager.joinTransaction();

            entityManager.createNamedQuery("users.updatePasswordById")
                    .setParameter("password", newUserData.password)
                    .setParameter("id", newUserData.id)
                    .executeUpdate();

            userTransaction.commit();
            return true;

        } catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return false;
        }
    }

    public boolean updatePatientCabs(EPatientCabs ePatientCabs){
        try {
            userTransaction.begin();
            entityManager.joinTransaction();

            EPatientCabs ep = entityManager.find(EPatientCabs.class, ePatientCabs.id);
            ep.description = ePatientCabs.description;
            ep.properties = ePatientCabs.properties;


            userTransaction.commit();
            return true;

        } catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return false;
        }
    }
}
