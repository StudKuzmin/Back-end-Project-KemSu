package classes.model.modelRequests;

import classes.database.dbservice.IDBservice;
import classes.database.entity.EPassword;
import classes.database.entity.EUser;
import classes.model.modelLogic.IModelLogic;
import classes.model.modelRequests.interfaces.IUsersModel;
import jakarta.inject.Inject;

import java.util.List;

public class UsersModel implements IUsersModel {
    @Inject
    IDBservice dbservice;
    @Inject
    IModelLogic modelLogic;

    public Integer postUserLogin(EUser euser){
        String entity = "users";
        try {
            // Достаём из БД данные
            List<EUser> userList = dbservice.selectUsers();

            // Расшифровка данных с БД
            List<EUser> decryptedUserList = modelLogic.getDecryptedUserList(userList);

            for (EUser e : decryptedUserList) {
                if (euser.login.equals(e.login) && euser.password.equals(e.password)) {
                    return e.id;
                }
            }
            return null;
        }
        catch(Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return null;
        }
    }
    public List<EUser> getUserList() throws Exception{
        String entity = "users";
        try {
            // Достаём из БД данные
            List<EUser> userList = dbservice.selectUsers();

            // Расшифровка данных с БД
            List<EUser> decryptedUserList = modelLogic.getDecryptedUserList(userList);

            return decryptedUserList;
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception("ERROR while select");
        }
    }
    public boolean createUser(EUser euser) throws Exception{
        try {
            EUser encryptedUser = modelLogic.getEncryptedUser(euser);

            return dbservice.insert(encryptedUser);
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return false;
        }
    }

    public EUser getOneUser(String userId) throws Exception{
        String entity = "users";
        try {
            // Достаём из БД данные
            List<EUser> userList = dbservice.selectUsers();

            // Расшифровка данных с БД
            List<EUser> decryptedUserList = modelLogic.getDecryptedUserList(userList);

            for (EUser e : decryptedUserList) {
                if (userId.equals(String.valueOf(e.id))) {
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
    public EUser deleteOneUser(String userId) throws Exception{
        String entity = "users";
        try {
            // Достаём из БД данные
            List<EUser> userList = dbservice.selectUsers();

            // Расшифровка данных с БД
            List<EUser> decryptedUserList = modelLogic.getDecryptedUserList(userList);

            for(EUser e: decryptedUserList){
                if (userId.equals(String.valueOf(e.id)))
                    if(dbservice.delete(entity, userId)) {
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
    public EUser updateOneUser(String userId, EUser newUserData) throws Exception{
        try {
            // Достаём из БД старые данные
            List<EUser> userList = dbservice.selectUsers();

            // Расшифровка старых данных с БД
            List<EUser> decryptedUserList = modelLogic.getDecryptedUserList(userList);

            // Шифровка новых данных для инсерта в БД
            EUser newEncryptedUserData = modelLogic.getEncryptedUser(newUserData);

            for(EUser e: decryptedUserList){
                if (userId.equals(String.valueOf(e.id))){
                    boolean updated = dbservice.update("users", userId, newEncryptedUserData);
                    if (updated)
                        return newUserData;
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

    public EPassword resetPassword(String userId, String newPassword) throws Exception{
        String entity = "users";
        try {
            // Достаём из БД данные
            List<EUser> userList = dbservice.selectUsers();

            // Расшифровка данных с БД
            List<EUser> decryptedUserList = modelLogic.getDecryptedUserList(userList);

            for(EUser e: decryptedUserList){
                if (userId.equals(String.valueOf(e.id))){
                    e.password = newPassword;
                    EUser encryptedUserData = modelLogic.getEncryptedUser(e);
                    boolean updated = dbservice.update(entity, userId, encryptedUserData);
                    if(updated)
                        return new EPassword(newPassword);
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
