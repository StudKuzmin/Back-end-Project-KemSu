package classes.model.modelRequests.interfaces;

import classes.database.entity.EPassword;
import classes.database.entity.EUser;

import java.util.List;

public interface IUsersModel {
    public Integer postUserLogin(EUser euser);
    public List<EUser> getUserList() throws Exception;
    public boolean createUser(EUser euser) throws Exception;
    public EUser getOneUser(String userId) throws Exception;
    public EUser deleteOneUser(String userId) throws Exception;
    public EUser updateOneUser(String userId, EUser newUserData) throws Exception;
    public EPassword resetPassword(String userId, String newPassword) throws Exception;

}
