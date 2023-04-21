package classes.controller.controller.interfaces;

import classes.database.entity.EPassword;
import classes.database.entity.EUser;

import java.util.List;

public interface IUsersController {
    public String postUserLogin(String userDataJSON) throws Exception;
    public List<EUser> getUserList(String accessToken) throws Exception;
    public EUser createUser(String accessToken, String userDataJSON) throws Exception;
    public EUser getOneUser(String accessToken, String userId) throws Exception;
    public EUser deleteOneUser(String accessToken, String userId) throws Exception;
    public EUser updateOneUser(String accessToken, String userId, String userDataJSON) throws Exception;
    public EPassword resetPassword(String accessToken, String userId, String newPassword) throws Exception;
}
