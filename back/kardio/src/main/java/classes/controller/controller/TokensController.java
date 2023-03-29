package classes.controller.controller;

import classes.controller.controllerLogic.ControllerLogic;
import classes.database.entity.EUser;
import jakarta.inject.Inject;


public class TokensController {
    @Inject
    ControllerLogic controllerLogic;

    public String refreshToken(String refreshToken) throws Exception {
        String token;
        EUser euser;

        boolean refreshTokenIsOk;

        refreshTokenIsOk = controllerLogic.checkUserToken(refreshToken, "refreshToken");

        if(refreshTokenIsOk) {
            euser = controllerLogic.getUserDataWithToken(refreshToken);
            try {
                token = controllerLogic.getUserToken(euser.id, euser.role);
            }
            catch (Exception ex){
                System.out.printf("ERROR in %s.%s: %s%n",
                        this.getClass(),
                        new Throwable().getStackTrace()[0].getMethodName(),
                        ex.getMessage());
                throw new Exception("ERROR");
            }
            return token;
        }
        else throw new Exception("BAD TOKEN");

    }
}
