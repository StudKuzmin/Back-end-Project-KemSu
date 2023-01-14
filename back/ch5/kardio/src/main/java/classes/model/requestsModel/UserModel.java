package classes.model.requestsModel;

import classes.controller.entity.EUser;
import classes.database.DBservice;
import classes.model.requestsModel.interfaces.IUserModel;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private DBservice dbservice;
    public UserModel(){
        dbservice = new DBservice();
    }

    public boolean userLoginPost(String login, String password){
        return dbservice.checkUserData(login, password);
    }
    public List<EUser> getUserList(){
        List<EUser> userListJSON = new ArrayList<>();
        List<ArrayList<String>> userList = dbservice.getUserList();

        for(int i = 0; i < userList.size(); i++){
            String id = userList.get(i).get(0);
            String registrationDate = userList.get(i).get(1);
            String fullName = userList.get(i).get(2);
            String login = userList.get(i).get(3);
            String password = userList.get(i).get(4);
            String role = userList.get(i).get(5);
            String status = userList.get(i).get(6);
            String deletionDate = userList.get(i).get(7);

            userListJSON.add(new EUser(id,
                    registrationDate,
                    fullName,
                    login,
                    password,
                    role,
                    status,
                    deletionDate));
        }

        return userListJSON;
    }

    public List<String> createUser(EUser euser) throws Exception{
        try {
            boolean userCreated = false;
            List<String> userData = new ArrayList<>(List.of(euser.login,
                    euser.password,
                    euser.id,
                    euser.role,
                    euser.deletionDate,
                    euser.fullName,
                    euser.registrationDate,
                    euser.status));

            userCreated = dbservice.createUser(euser);

            if(userCreated)
                return userData;
            throw new Exception();
        }
        catch(Exception ex) {
            System.out.println("ERROR in UserModel.createUser: " + ex);
            throw new Exception();
        }
    }
}
