package classes.controller.requests;

import classes.controller.Controller.Controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserController {
    private final Controller controller;

    public UserController(){
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
}
