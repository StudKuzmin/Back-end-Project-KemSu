package classes.model.requestsModel;

import classes.database.entity.EUser;
import classes.database.DBservice;
import classes.model.model.Model;
import jakarta.inject.Inject;

import java.util.List;

public class UsersModel {
    @Inject
    DBservice dbservice;
    @Inject
    Model model;

    public boolean userLoginPost(EUser euser){
        String entity = "users";
        try {
            List<Object> objectList = dbservice.select(entity);
            List<EUser> userList = objectList.stream()
                    .map(element -> (EUser)element).toList();

            for (EUser e : userList) {
                if (euser.login.equals(e.login) && euser.password.equals(e.password))
                    return true;
            }
            return false;
        }
        catch(Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return false;
        }
    }
    public List<EUser> getUserList() throws Exception{
        String entity = "users";
        try {
            List<Object> objectList = dbservice.select(entity);
            List<EUser> userList = objectList.stream()
                    .map(element -> (EUser)element).toList();

            return userList;
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
            return dbservice.insert(euser);
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
            List<Object> objectList = dbservice.select(entity);
            List<EUser> userList = objectList.stream()
                    .map(element -> (EUser)element).toList();

            for (EUser e : userList) {
                if (userId.equals(String.valueOf(e.id)))
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
    public EUser deleteOneUser(String userId) throws Exception{
        String entity = "users";
        try {
            List<Object> objectList = dbservice.select(entity);
            List<EUser> userList = objectList.stream()
                    .map(element -> (EUser)element).toList();

            for(EUser e: userList){
                if (userId.equals(String.valueOf(e.id)))
                    if(dbservice.delete(entity, userId))
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
    public EUser updateOneUser(String userId, EUser newUserData) throws Exception{
        String entity = "users";
        try {
            List<Object> objectList = dbservice.select(entity);
            List<EUser> userList = objectList.stream()
                    .map(element -> (EUser)element).toList();

            for(EUser e: userList){
                if (userId.equals(String.valueOf(e.id)))
                    if(dbservice.update(entity, userId, newUserData))
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
