package classes.controller.controller;

import classes.controller.controller.interfaces.IUsersController;
import classes.controller.controllerLogic.IControllerLogic;
import classes.database.entity.EPassword;
import classes.database.entity.EToken;
import classes.database.entity.user.EUser;
import classes.database.entity.user.EUserPage;
import classes.model.modelRequests.interfaces.IUsersModel;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Map;


public class UsersController implements IUsersController {
    @Inject
    IUsersModel usersModel;
    @Inject
    IControllerLogic controllerLogic;

    public EToken postUsersLogin(String userDataJSON) throws Exception{
        try {
            EUser euser = controllerLogic.fromUserJson(userDataJSON);
            String userId = usersModel.postUsersLogin(euser);
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
    public List<EUserPage> getUserList(String accessToken) throws Exception{
        boolean accessTokenIsOk = false;
        List<EUserPage> userList;

        try {
            accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
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
    public EUser postUsers(String accessToken, String userDataJSON) throws Exception{
        EUser euser;
        boolean accessTokenIsOk = false;

        //accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
        //if(accessTokenIsOk){
            boolean userCreated = false;
            try {
                euser = controllerLogic.fromUserJson(userDataJSON);
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
       // }
       // else throw new Exception("BAD TOKEN");
    }
    public EUser getUsersUserid(String accessToken, String userId) throws Exception{
        boolean accessTokenIsOk = false;
        EUser euser;

        accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
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
    public EUser deleteUsersUserid(String accessToken, String userId) throws Exception{
        boolean accessTokenIsOk = false;

        accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
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
    public EUser updateUsersUserid(String accessToken, String userId, String userDataJSON) throws Exception{
        boolean accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                EUser newDataUser = controllerLogic.fromUserJson(userDataJSON);
                newDataUser.id = userId;
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

    public Map<String, String> postUsersUseridPasswordsReset(String accessToken, String userId, String newPassword) throws Exception{
        boolean accessTokenIsOk = false;

        accessTokenIsOk = controllerLogic.checkToken(accessToken, "accessToken");
        if(accessTokenIsOk){
            try {
                Map<String, String> password = controllerLogic.toMap(newPassword);
                return usersModel.resetPassword(userId, password);
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

    public EToken postUsersUseridTokensRefresh(String token, String userId) throws Exception {
        EToken eToken = controllerLogic.fromTokenJson(token);


        boolean refreshTokenIsOk = controllerLogic.checkToken(eToken.refreshToken, "refreshToken");
        if(refreshTokenIsOk) {
            EToken newToken;
            EUser euser = controllerLogic.getUserDataWithToken(eToken.refreshToken, userId);
            try {
                newToken = controllerLogic.getUserToken(euser.id, "user");
            }
            catch (Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception("ERROR");
            }
            return newToken;
        }
        else throw new Exception("BAD TOKEN");

    }
}
