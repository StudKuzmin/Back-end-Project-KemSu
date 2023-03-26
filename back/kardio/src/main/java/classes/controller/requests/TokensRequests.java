package classes.controller.requests;

import classes.controller.controller.TokensController;
import classes.database.entity.EError;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/tokens")
public class TokensRequests {
    @Inject
    TokensController tokensController;

    @POST
    @Path("/refresh")
    @Consumes("application/json")
    @Produces("application/json")
    public Response refreshPost(String refreshToken) {

        String token;
        try {
            token = tokensController.refreshToken(refreshToken);

            return Response
                    .ok(token)
                    .status(200)
                    .build();
        }
        catch (Exception ex) {
            System.out.println("ERROR in TokensController.refreshPost: " + ex);
        }

        return Response
                .ok(new EError("authentication failed"))
                .status(403)
                .build();
    }
}
