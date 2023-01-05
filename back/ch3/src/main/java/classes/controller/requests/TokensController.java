package classes.controller.requests;

import classes.controller.Controller.Controller;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/tokens")
public class TokensController {
    private final Controller controller;

    public TokensController(){
        controller = new Controller(); // TODO DELETE DEPENDENCE
    }
    @POST
    @Path("/refresh")
    @Consumes("application/json")
    @Produces("application/json")
    public Response refreshPost(String refreshToken) {

        String token;
        try {
            token = controller.refreshToken(refreshToken);
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
