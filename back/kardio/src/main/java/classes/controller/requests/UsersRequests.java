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
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Map;

@Path("/users")
public class UsersRequests {
    @Inject
    IUsersController usersController;

    @POST
    @Path("/{userId}/passwords/reset")
    @Consumes("application/json")
    @Produces("application/json")
    public Response postUsersUseridPasswordsReset(@HeaderParam("accessToken") String accessToken, @PathParam("userId") String userId, String newPassword) {
        try {
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
                    .ok(new EError("Password reset succesfully", 401))
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
    @Consumes("application/json")
    @Produces("application/json")
    public Response getUsersUserid(@HeaderParam("accessToken") String accessToken, @PathParam("userId") String userId) {
        try {
            EUser userData = usersController.getUsersUserid(accessToken, userId);
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
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteUsersUserid(@HeaderParam("accessToken") String accessToken, @PathParam("userId") String userId) {
        try {
            EUser euser = usersController.deleteUsersUserid(accessToken, userId);
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
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateUsersUserid(@HeaderParam("accessToken") String accessToken, @PathParam("userId") String userId, String userDataJSON) {
        try {
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
    @Consumes("application/json")
    @Produces("application/json")
    public Response postUsersLogin(String userDataJSON) {
        try {
            EToken etoken = usersController.postUsersLogin(userDataJSON);
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
    @Consumes("application/json")
    @Produces("application/json")
    public Response getUsers(@HeaderParam("accessToken") String accessToken) {
        try {
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
    @Consumes("application/json")
    @Produces("application/json")
    public Response postUsers(@HeaderParam("accessToken") String accessToken, String userDataJSON) {
        try {
            EUser euser = usersController.postUsers(accessToken, userDataJSON);
            return Response
                    .ok(euser)
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
    @Consumes("application/json")
    @Produces("application/json")
    public Response postUsersUseridTokensRefresh(String token, @PathParam("userId") String userId) {
        try {
            EToken newToken = usersController.postUsersUseridTokensRefresh(token, userId);
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