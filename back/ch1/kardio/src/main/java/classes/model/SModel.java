package classes.model;

import classes.model.RequestsModeling.UserModel;

public class SModel {
    private static SModel instance;
    private static UserModel userModeling;

    private SModel(){
        userModeling = new UserModel();
    }
    public static void getInstance(){
        if(instance == null){
            instance = new SModel();
        }
    }
    public static void userGenerateToken(String userDataJSON){
    }
}
