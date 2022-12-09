package classes.controller.Requests;

import classes.controller.SController;

import classes.model.RequestsModeling.Interfaces.IUserModel;
import classes.model.RequestsModeling.UserModel;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class ControllerUser {
    private final IUserModel userModel;

    public ControllerUser(){
        userModel = new UserModel();
    }
    @POST
    @Path("/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response loginPost(String userDataJSON) {
        try {
            Boolean dataIsOk = false;
            //userModel.userGenerateToken(userDataJSON);
            return Response.ok("SUCCESS POST(/users/login)").build();
        }
        catch(Exception ex) {
            return Response.ok("ERROR POST(/users/login)").build();
        }
    }

}
