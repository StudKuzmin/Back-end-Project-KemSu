package classes.controller.requests;

import classes.controller.controller.interfaces.IReportsController;
import classes.database.entity.EError;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/reports")
public class ReportsRequests {
    @Inject
    IReportsController reportsController;

    @GET
    @Path("/covid")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getCovidReport(String accessToken) {
        try {
            reportsController.test();
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
    public Response getCabsReport(String accessToken) {
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
