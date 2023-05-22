package classes.controller.controller.interfaces;

import classes.database.entity.EPassword;
import classes.database.entity.EToken;
import classes.database.entity.user.EUser;
import classes.database.entity.user.EUserPage;

import java.util.List;
import java.util.Map;

public interface IUsersController {
    public EToken postUsersLogin(String userDataJSON) throws Exception;
    public List<EUserPage> getUserList(String accessToken) throws Exception;
    public EUser postUsers(String accessToken, String userDataJSON) throws Exception;
    public EUser getUsersUserid(String accessToken, String userId) throws Exception;
    public EUser deleteUsersUserid(String accessToken, String userId) throws Exception;
    public EUser updateUsersUserid(String accessToken, String userId, String userDataJSON) throws Exception;
    public Map<String, String> postUsersUseridPasswordsReset(String accessToken, String userId, String newPassword) throws Exception;
    public EToken postUsersUseridTokensRefresh(String refreshToken, String userId) throws Exception;
}
