package classes.controller.requests;

import classes.controller.controller.interfaces.IUsersController;
import classes.database.entity.EError;
import classes.database.entity.EPassword;
import classes.database.entity.EToken;
import classes.database.entity.user.EUser;

import classes.database.entity.user.EUserPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.json.JsonObject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Path("/users")
public class UsersRequests {
    @Inject
    IUsersController usersController;

    @POST
    @Path("/test")
    @Consumes("application/json")
    @Produces("application/json")
    public Response Test(String data) {
        try {
            System.out.println("TEST DATA: " + data);
            System.out.println("TEST s: " + data);
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return Response
                .ok(new Gson().toJson(data))
                .status(200)
                .build();
    }

    @POST
    @Path("/{userId}/passwords/reset")
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public Response postUsersUseridPasswordsReset(@HeaderParam("Authorization") String accessToken, @PathParam("userId") String userId, String newPassword) {
        try {
            System.out.println("TEST NEW PASSWORD: " + newPassword);

            usersController.postUsersUseridPasswordsReset(accessToken, userId, newPassword);

//            String json = "[{\"contents\":[{\"id\":0,\"firstName\":\"string\",\"middleName\":\"string\",\"lastName\":\"string\",\"username\":\"string\",\"isDeleted\":true,\"createdAt\":0,\"updatedAt\":0}],\"page\":1,\"pageSize\":100,\"numberOfElements\":0,\"totalPages\":0,\"totalElements\":0}]";
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            List<Map<String, String>> map = new Gson().fromJson(json, List.class);
//
//            List<EUserPage> eUserPage = objectMapper.convertValue(map, List.class); // map -> entity
//            List<Map<String, String>> mymap = objectMapper.convertValue(eUserPage, List.class); // entity -> map
//

            return Response
                    .ok(new EError("Password reset succesfully", 200))
                    .status(204)
                    .build();

        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return Response
                .ok(new EError("Bad request", 401))
                .status(401)
                .build();
    }

    @GET
    @Path("/{userId}")
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public Response getUsersUserid(@HeaderParam("Authorization") String accessToken, @PathParam("userId") String userId) {
        try {
            long startTime = System.nanoTime();
            EUser userData = usersController.getUsersUserid(accessToken, userId);
            long endTime = System.nanoTime();
            double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);


            return Response
                    .ok(userData)
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
                .ok(new EError("Unauthorized", 401))
                .status(401)
                .build();
    }

    @DELETE
    @Path("/{userId}")
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public Response deleteUsersUserid(@HeaderParam("Authorization") String accessToken, @PathParam("userId") String userId) {
        try {
            long startTime = System.nanoTime();
            EUser euser = usersController.deleteUsersUserid(accessToken, userId);
            long endTime = System.nanoTime();
            double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);


            return Response
                    .ok(new EError("User deleted successfully", 204))
                    .status(204)
                    .build();
        }
        catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
        }

        return Response
                .ok(new EError("Unauthorized", 401))
                .status(401)
                .build();
    }

    @PATCH
    @Path("/{userId}")
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public Response updateUsersUserid(@HeaderParam("Authorization") String accessToken, @PathParam("userId") String userId, String userDataJSON) {
        try {
            System.out.println("TEST UPDATE userDataJSON: " + userDataJSON);

            EUser euser = usersController.updateUsersUserid(accessToken, userId, userDataJSON);


            return Response
                    .ok(new EError("Updated successfully", 200))
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
                .ok(new EError("Unauthorized", 401))
                .status(401)
                .build();
    }

    @POST
    @Path("/login")
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public Response postUsersLogin(String userDataJSON) {
        try {
            System.out.println("TEST DATA: " + userDataJSON);
            EToken etoken = usersController.postUsersLogin(userDataJSON);

            System.out.println("RETURNED TOKEN: " + etoken.accessToken);

            return Response
                    .ok(etoken)
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
                .ok(new EError("Bad request", 400))
                .status(400)
                .build();
    }

    @GET
    @Path("/")
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public Response getUsers(@HeaderParam("Authorization") String accessToken) {
        try {
            System.out.println("TEST TOKEN: " + accessToken);


            List<EUserPage> userList = usersController.getUserList(accessToken);

            return Response
                    .ok(userList)
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
                .ok(new EError("Unauthorized", 401))
                .status(401)
                .build();
    }

    @POST
    @Path("/")
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public Response postUsers(@HeaderParam("Authorization") String accessToken, String userDataJSON) {
        try {
            EUser euser = usersController.postUsers(accessToken, userDataJSON);

            return Response
                    .ok(userDataJSON)
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
                .ok(new EError("Unauthorized", 401))
                .status(401)
                .build();
    }

    @POST
    @Path("/{userId}/tokens/refresh")
    @Consumes("application/json;charset=utf-8")
    @Produces("application/json;charset=utf-8")
    public Response postUsersUseridTokensRefresh(String token, @PathParam("userId") String userId) {
        try {
            long startTime = System.nanoTime();
            EToken newToken = usersController.postUsersUseridTokensRefresh(token, userId);
            long endTime = System.nanoTime();
            double durationSeconds = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("TEST TIME " + new Throwable().getStackTrace()[0].getMethodName() + ": " + durationSeconds);


            return Response
                    .ok(newToken)
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
                .ok(new EError("Bad request", 400))
                .status(400)
                .build();
    }
}