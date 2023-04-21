package classes.controller.requests;

import classes.controller.controller.MachineModelsController;
import classes.database.entity.EError;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path("/machine-models")
public class MachineModelsRequests {
    @Inject
    MachineModelsController machineModelsController;

    @GET
    @Path("/covid")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getCovidModelsList(String accessToken) {
        try {
            return Response
                    .ok("OK")
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

    @GET
    @Path("/cabs")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getCabsModelsList(String accessToken) {
        try {
            return Response
                    .ok("OK")
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