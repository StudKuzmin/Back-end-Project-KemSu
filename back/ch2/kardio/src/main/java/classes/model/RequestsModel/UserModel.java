package classes.model.RequestsModel;

import classes.database.DBservice;
import classes.model.RequestsModel.Interfaces.IUserModel;

public class UserModel implements IUserModel {
    private DBservice dbservice;
    public UserModel(){
        dbservice = new DBservice();
    }

    public boolean userLoginPost(String login, String password){
        return dbservice.userLogin(login, password);
    }
    public String userGenerateToken(String userDataJSON){
        return "test";
    }
}
