package classes.controller.controller;

import classes.controller.controllerLogic.ControllerLogic;
import classes.model.requestsModel.UsersModel;
import classes.database.entity.EUser;
import jakarta.inject.Inject;

import java.util.List;


public class UsersController {
    @Inject
    UsersModel usersModel;
    @Inject
    ControllerLogic controllerLogic;

    public String userLoginPost(String userDataJSON) throws Exception{
        try {
            EUser euser = controllerLogic.userFromJson(userDataJSON);
            Integer userId = usersModel.userLoginPost(euser);
            if (userId != null) {
                return controllerLogic.getUserToken(userId,"user");
            }
            else throw new Exception("BAD USER DATA");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception();
        }
    }
    public List<EUser> getUserList(String accessToken) throws Exception{
        boolean accessTokenIsOk = false;
        List<EUser> userList;

        try {
            accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
            if (accessTokenIsOk) {
                userList = usersModel.getUserList();
                return userList;
            }
            else throw new Exception("BAD TOKEN");
        }
        catch (Exception ex){
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception();
        }
    }
    public EUser createUser(String accessToken, String userDataJSON) throws Exception{
        EUser euser;
        boolean accessTokenIsOk = false;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            boolean userCreated = false;
            try {
                euser = controllerLogic.userFromJson(userDataJSON);
                userCreated = usersModel.createUser(euser);
                if(userCreated)
                    return euser;
                throw new Exception("user creation error");
            }
            catch (Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception();
            }
        }
        else throw new Exception("BAD TOKEN");
    }
    public EUser getOneUser(String accessToken, String userId) throws Exception{
        boolean accessTokenIsOk = false;
        EUser euser;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                euser = usersModel.getOneUser(userId);
                return euser;
            }
            catch(Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception("some error");
            }
        }
        else throw new Exception("BAD TOKEN");
    }
    public EUser deleteOneUser(String accessToken, String userId) throws Exception{
        boolean accessTokenIsOk = false;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                return usersModel.deleteOneUser(userId);
            }
            catch(Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception("ERROR while delete one user");
            }
        }
        else throw new Exception("BAD TOKEN");
    }
    public EUser updateOneUser(String accessToken, String userId, String userDataJSON) throws Exception{
        boolean accessTokenIsOk = false;

        accessTokenIsOk = controllerLogic.checkUserToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                EUser newDataUser = controllerLogic.userFromJson(userDataJSON);
                return usersModel.updateOneUser(userId, newDataUser);
            }
            catch(Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception("ERROR while update one user");
            }
        }
        else throw new Exception("BAD TOKEN");
    }
}
