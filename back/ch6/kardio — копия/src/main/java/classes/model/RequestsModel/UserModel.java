package classes.model.RequestsModel;

import classes.database.DBservice;
import classes.model.RequestsModel.Interfaces.IUserModel;

public class UserModel implements IUserModel {
    private DBservice dbservice;
    public UserModel(){
        dbservice = new DBservice();
    }

    public boolean userCheckData(String login, String password){
        boolean userDataIsOk = dbservice.userLogin(login, password);
        return userDataIsOk;
    }
    public String userGenerateToken(String userDataJSON){
        return "test";
    }
}
