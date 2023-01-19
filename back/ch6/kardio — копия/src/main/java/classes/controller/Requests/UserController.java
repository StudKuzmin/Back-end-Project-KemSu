package classes.controller.Requests;

import classes.controller.Controller;

import classes.model.RequestsModel.Interfaces.IUserModel;
import classes.model.RequestsModel.UserModel;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserController {
    private final IUserModel userModel;
    private final Controller controller;

    public UserController(){
        userModel = new UserModel();
        controller = new Controller();
    }
    @POST
    @Path("/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response loginPost(String userDataJSON) {
        try {
            String token;
            Boolean userDataIsOk = false;
            userDataIsOk = controller.userCheckData(userDataJSON);

            if (userDataIsOk) {
                return Response
                        .ok("SUCCESS POST(/users/login)")
                        .status(200)
                        .build();
            }
            return Response
                    .ok("unauthorized")
                    .status(401)
                    .build();

        }
        catch (Exception ex) {
            return Response
                    .ok("unauthorized")
                    .status(401)
                    .build();
        }
    }

}
