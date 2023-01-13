package classes.controller.requests;

import classes.controller.controller.Controller;

import classes.controller.entity.EUser;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UsersController {
    private final Controller controller;

    public UsersController(){
        controller = new Controller(); // TODO DELETE DEPENDENCE
    }
    @POST
    @Path("/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response loginPost(String userDataJSON) {
        try {
            String token;

            token = controller.userLoginPost(userDataJSON);
            return Response
                    .ok(token)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            System.out.println("ERROR in UserController.loginPost: " + ex);

            return Response
                    .ok("unauthorized")
                    .status(401)
                    .build();
        }
    }

    @GET
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getUsers(@HeaderParam("accessToken") String accessToken) {
        List<EUser> userList;
        try {
            userList = controller.userGetList(accessToken);
            return Response
                    .ok(userList)
                    .status(200)
                    .build();

        }
        catch (Exception ex) {
            return Response
                    .ok("authorization failed")
                    .status(401)
                    .build();
        }
    }
}
