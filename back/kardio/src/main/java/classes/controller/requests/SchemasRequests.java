package classes.controller.requests;

import classes.database.entity.EError;
import classes.database.entity.EModelContent;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/schemas")
public class SchemasRequests {
//    @GET
//    @Path("/")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response getSchemas(String accessToken) {
//        try {
//
//            return Response
//                    .ok("OKGET")
//                    .status(200)
//                    .build();
//        }
//        catch (Exception ex) {
//            System.out.printf("ERROR in %s.%s: %s%n",
//                    this.getClass(),
//                    new Throwable().getStackTrace()[0].getMethodName(),
//                    ex.getMessage());
//        }
//
//        return Response
//                .ok(new EError("authentication failed"))
//                .status(403)
//                .build();
//    }
//
//    @POST
//    @Path("/")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response postSchemas(String accessToken) {
//        try {
//
//            return Response
//                    .ok("OKPOST")
//                    .status(200)
//                    .build();
//        }
//        catch (Exception ex) {
//            System.out.printf("ERROR in %s.%s: %s%n",
//                    this.getClass(),
//                    new Throwable().getStackTrace()[0].getMethodName(),
//                    ex.getMessage());
//        }
//
//        return Response
//                .ok(new EError("authentication failed"))
//                .status(403)
//                .build();
//    }
}
