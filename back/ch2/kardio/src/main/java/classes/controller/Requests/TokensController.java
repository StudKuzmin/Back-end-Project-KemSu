package classes.controller.Requests;

import classes.controller.Controller.Controller;
import classes.controller.ControllerLogic.ControllerLogic;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/tokens")
public class TokensController {
    private final Controller controller;
    private final ControllerLogic controllerLogic;

    public TokensController(){
        controller = new Controller(); // TODO DELETE DEPENDENCE
        controllerLogic = new ControllerLogic(); // TODO DELETE DEPENDENCE
    }
    @POST
    @Path("/refresh")
    @Consumes("application/json")
    @Produces("application/json")
    public Response refreshPost(String refreshToken) {

        String token = "UNDEFINED";
        try {
            token = controller.refreshToken(refreshToken);

//            if (token.equals("UNDEFINED"))
//                throw new Exception();
        }
        catch (Exception ex) {
            System.out.println("ERROR in TokensController.refreshPost: " + ex);

            return Response
                    .ok("BAD TOKEN")
                    .build();
        }

        return Response
                .ok(token)
                .build();
    }
}
