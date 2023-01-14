package classes.controller.entity;

import java.util.List;

public class EUser {
    public EUser(){}
    public EUser(String id,
                 String registrationDate,
                 String fullName,
                 String login,
                 String password,
                 String role,
                 String status,
                 String deletionDate){
        this.id = id == null? "UNDEFINED": id;
        this.registrationDate = registrationDate == null? "UNDEFINED": registrationDate;
        this.fullName = fullName == null? "UNDEFINED": fullName;
        this.login = login == null? "UNDEFINED": login;
        this.password = password == null? "UNDEFINED": password;
        this.role = role == null? "UNDEFINED": role;
        this.status = status == null? "UNDEFINED": status;
        this.deletionDate = deletionDate == null? "UNDEFINED": deletionDate;
    }
    public String id = "UNDEFINED";
    public String registrationDate = "UNDEFINED";
    public String fullName = "UNDEFINED";
    public String login = "UNDEFINED";
    public String password = "UNDEFINED";
    public String role = "UNDEFINED";
    public String status = "UNDEFINED";
    public String deletionDate = "UNDEFINED";
}
