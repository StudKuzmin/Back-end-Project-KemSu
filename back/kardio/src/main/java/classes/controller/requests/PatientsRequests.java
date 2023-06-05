package classes.controller.requests;

import classes.controller.controller.interfaces.IPatientsController;
import classes.database.entity.EError;
import classes.database.entity.patient.EPatientPage;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/patients")
public class PatientsRequests {
    @Inject
    IPatientsController patientsController;

    @GET
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getPatients(@HeaderParam("Authorization") String accessToken, @QueryParam("type") String type) {
        try {
            List<EPatientPage> patientList = patientsController.getPatients(accessToken, type);

            return Response
                    .ok(patientList)
                    .status(200)
                    .build();
        }
        catch (Exception ex){
            return Response
                    .ok(new EError("Unauthorized", 401))
                    .status(401)
                    .build();
        }
    }
    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public Response postPatients(@HeaderParam("Authorization") String accessToken, String patientDataJSON) {
        try {
            long startTime = System.nanoTime();
            Map<String, String> insertedPatientData = patientsController.postPatients(accessToken, patientDataJSON);
            long endTime = System.nanoTime();
            double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);


            return Response
                    .ok(insertedPatientData)
                    .status(200)
                    .build();
        }
        catch(Exception ex){
            return Response
                    .ok(new EError("Unauthorized", 401))
                    .status(401)
                    .build();
        }
    }
    @GET
    @Path("/{patientId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response getPatientsPatientid(@HeaderParam("Authorization") String accessToken, @PathParam("patientId") String patientId) {
        try {
            long startTime = System.nanoTime();
            Map<String, String> patientData = patientsController.getPatientsPatientid(accessToken, patientId);
            long endTime = System.nanoTime();
            double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);


            return Response
                    .ok(patientData)
                    .status(200)
                    .build();

        }
        catch(Exception ex){
            return Response
                    .ok(new EError("Unauthorized", 401))
                    .status(401)
                    .build();
        }
    }
    @DELETE
    @Path("/{patientId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deletePatientsPatientid(@HeaderParam("Authorization") String accessToken, @PathParam("patientId") String patientId) {
        try {
            long startTime = System.nanoTime();
            patientsController.deletePatientsPatientid(accessToken, patientId);
            long endTime = System.nanoTime();
            double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);


            return Response
                    .ok(new EError("Patient deleted successfully", 200))
                    .status(200)
                    .build();
        }
        catch(Exception ex){
            return Response
                    .ok(new EError("Unauthorized", 401))
                    .status(401)
                    .build();
        }
    }
    @PATCH
    @Path("/{patientId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response patchPatientsPatientid(@HeaderParam("Authorization") String accessToken, @PathParam("patientId") String patientId, String patientDataJSON) {
        try {
            long startTime = System.nanoTime();
            Map<String, String> patientData = patientsController.patchPatientsPatientid(accessToken, patientId, patientDataJSON);
            long endTime = System.nanoTime();
            double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);

            return Response
                    .ok(patientData)
                    .status(200)
                    .build();
        }
        catch (Exception ex){
            return Response
                    .ok(new EError("Unauthorized", 401))
                    .status(401)
                    .build();
        }
    }
}