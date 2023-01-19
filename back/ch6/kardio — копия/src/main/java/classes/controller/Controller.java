package classes.controller;

import classes.controller.entity.EUser;
import classes.model.RequestsModel.UserModel;
import com.google.gson.Gson;

public class Controller {
    private static UserModel userModel;
    private static Gson gson;

    public Controller(){
        userModel = new UserModel();
        gson = new Gson();
    }
    public boolean userCheckData(String userDataJSON){
        String token = "false";
        EUser user = new EUser();
        boolean userDataIsOk;

        try {
            user = gson.fromJson(userDataJSON, EUser.class);
        }
        catch (Exception e) {
            System.out.println("Exception in SController.userCheckData(): " + e.getMessage());
            return false;
        }
        userDataIsOk = userModel.userCheckData(user.login, user.password);
        return userDataIsOk;
    }
}
