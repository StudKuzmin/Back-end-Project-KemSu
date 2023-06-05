package classes.model.modelRequests;

import classes.database.dbservice.IDBservice;
import classes.database.entity.EPassword;
import classes.database.entity.user.EUser;
import classes.database.entity.user.EUserPage;
import classes.model.modelLogic.IModelLogic;
import classes.model.modelRequests.interfaces.IUsersModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsersModel implements IUsersModel {
    @Inject
    IDBservice dbservice;
    @Inject
    IModelLogic modelLogic;

    public EUser postUsersLogin(EUser euser){
        long startTime = System.nanoTime();

        String entity = "users";
        try {
            // Достаём из БД данные
            List<EUser> userList = dbservice.selectUsers();

            // Расшифровка данных с БД
            List<EUser> decryptedUserList = modelLogic.getDecryptedUserList(userList);

//            System.out.println("DECRYPT: " + decryptedUserList.get(0).userName + " " + decryptedUserList.get(0).password + " " + decryptedUserList.get(0).id);

            for (EUser e : decryptedUserList) {
                if (euser.userName.equals(e.userName) && euser.password.equals(e.password)) {
                    long endTime = System.nanoTime();
                    double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
                    System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
                    return e;
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
    public List<EUserPage> getUserList() throws Exception{
        long startTime = System.nanoTime();
        String entity = "users";
        try {
            // Достаём из БД данные
            List<EUser> userList = dbservice.selectUsers();

            // Расшифровка данных с БД
            List<EUser> decryptedUserList = modelLogic.getDecryptedUserList(userList);

            // TODO сделать пагинацию страницу
            List<EUserPage> decryptedUserPageList = new ArrayList<>();
//            decryptedUserPageList.add(new EUserPage());
//            for (int i = 0, currentElement = 1, page = 1; i < decryptedUserList.size(); i++, currentElement++){
//                decryptedUserPageList.get(page-1).totalPages = decryptedUserList.size()/3+1;
//                decryptedUserPageList.get(page-1).totalElements = decryptedUserList.size();
//                decryptedUserPageList.get(page-1).contents.add(decryptedUserList.get(currentElement-1));
//                decryptedUserPageList.get(page-1).numberOfElements++;
//
//                // На каждый 100й элемент меняется страница
//                if(currentElement%5==0){
//                    decryptedUserPageList.add(new EUserPage());
//                    decryptedUserPageList.get(page-1).page = ++page;
//                }
//
//
//                System.out.println("TEST: " + page);
//            }


            decryptedUserPageList.add(
                    new EUserPage(
                            decryptedUserList, 1, 1, 1, decryptedUserList.size()));

            long endTime = System.nanoTime();
            double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
            return decryptedUserPageList;
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
        long startTime = System.nanoTime();
        try {
            long milliseconds = System.currentTimeMillis();

            // Преобразование миллисекунд в секунды
            long seconds = milliseconds / 1000;

            // Закидываем текущее время в поле
            euser.createdAt = String.valueOf(seconds);

            EUser encryptedUser = modelLogic.getEncryptedUser(euser);
            boolean inserted = dbservice.insert(encryptedUser);

            long endTime = System.nanoTime();
            double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
            return inserted;
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
        long startTime = System.nanoTime();
        String entity = "users";
        try {
            // Достаём из БД данные
            List<EUser> userList = dbservice.selectUsers();

            // Расшифровка данных с БД
            List<EUser> decryptedUserList = modelLogic.getDecryptedUserList(userList);

            for (EUser e : decryptedUserList) {
                if (userId.equals(String.valueOf(e.id))) {
                    long endTime = System.nanoTime();
                    double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
                    System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
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
        long startTime = System.nanoTime();
        String entity = "users";
        try {
            // TODO можно просто вызвать delete
            // Достаём из БД данные
            List<EUser> userList = dbservice.selectUsers();

            // Расшифровка данных с БД
            List<EUser> decryptedUserList = modelLogic.getDecryptedUserList(userList);

            for(EUser e: decryptedUserList){
                if (userId.equals(String.valueOf(e.id)))
                    if(dbservice.delete(entity, userId)) {
                        long endTime = System.nanoTime();
                        double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
                        System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
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
            throw new Exception("ERROR while select or delete");
        }
    }
    public EUser updateOneUser(String userId, EUser newUserData) throws Exception{
        long startTime = System.nanoTime();
        try {
            // Достаём из БД старые данные
            List<EUser> encryptedUserList = dbservice.selectUsers();

            // Расшифровка старых данных с БД
            List<EUser> decryptedUserList = modelLogic.getDecryptedUserList(encryptedUserList);

            // Шифровка новых данных для инсерта в БД
            EUser newEncryptedUserData = modelLogic.getEncryptedUser(newUserData);
            System.out.println("TEST UPDATE ENCRYPTEDUSER: " + newEncryptedUserData.userName + " " + newEncryptedUserData.firstName);

            for(EUser e: decryptedUserList){
                if (userId.equals(String.valueOf(e.id))){
                    boolean updated = dbservice.updateUserInfo(newEncryptedUserData);
                    if (!updated)
                        throw new Exception("not updated");
                    long endTime = System.nanoTime();
                    double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
                    System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
                    return newUserData;

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

    public Map<String, String> resetPassword(String userId, Map<String, String> newPassword) throws Exception{
        long startTime = System.nanoTime();
        String entity = "users";
        try {
            // Преобразуем мап в сущность
            ObjectMapper objectMapper = new ObjectMapper();
            EPassword ePassword = objectMapper.convertValue(newPassword, EPassword.class);

            // Достаём из БД данные
            List<EUser> userList = dbservice.selectUsers();

            // Расшифровка данных с БД
            List<EUser> decryptedUserList = modelLogic.getDecryptedUserList(userList);

            for(EUser e: decryptedUserList){
                if (userId.equals(String.valueOf(e.id))){
                    e.password = ePassword.password;
                    EUser encryptedUserData = modelLogic.getEncryptedUser(e);
                    boolean updated = dbservice.updateUserPassword(encryptedUserData);
                    if(updated) {
                        long endTime = System.nanoTime();
                        double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
                        System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);
                        return newPassword;
                    }
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
