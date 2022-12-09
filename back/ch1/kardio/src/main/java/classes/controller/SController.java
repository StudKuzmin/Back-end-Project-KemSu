package classes.controller;

import classes.model.SModel;

public class SController {
    private static SController instance;
    private SController(){}
    public static SController getInstance(){
        if(instance == null){
            instance = new SController();
        }
        return instance;
    }
    public static void userGenerateToken(String userDataJSON){
        SModel.userGenerateToken(userDataJSON);
    }
}
