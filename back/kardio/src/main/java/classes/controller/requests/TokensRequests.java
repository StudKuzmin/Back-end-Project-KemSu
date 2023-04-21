package classes.controller.requests;

import classes.controller.controller.interfaces.ITokensController;
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
    ITokensController tokensController;

    @POST
    @Path("/refresh")
    @Consumes("application/json")
    @Produces("application/json")
    public Response postRefresh(String refreshToken) {

        String token;
        try {
            token = tokensController.refreshToken(refreshToken);
            return Response
                    .ok(token)
                    .status(200)
                    .build();
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return Response
                .ok(new EError("authentication failed"))
                .status(403)
                .build();
    }
}
