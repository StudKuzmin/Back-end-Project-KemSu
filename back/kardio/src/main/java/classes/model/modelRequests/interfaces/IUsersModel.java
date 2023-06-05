package classes.model.modelRequests.interfaces;

import classes.database.entity.EPassword;
import classes.database.entity.user.EUser;
import classes.database.entity.user.EUserPage;

import java.util.List;
import java.util.Map;

public interface IUsersModel {
    public EUser postUsersLogin(EUser euser);
    public List<EUserPage> getUserList() throws Exception;
    public boolean createUser(EUser euser) throws Exception;
    public EUser getOneUser(String userId) throws Exception;
    public EUser deleteOneUser(String userId) throws Exception;
    public EUser updateOneUser(String userId, EUser newUserData) throws Exception;
    public Map<String, String> resetPassword(String userId, Map<String, String> newPassword) throws Exception;

}
