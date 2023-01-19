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
        this.id = String.valueOf(id);
        this.registrationDate = String.valueOf(registrationDate);
        this.fullName = String.valueOf(fullName);
        this.login = String.valueOf(login);
        this.password = String.valueOf(password);
        this.role = String.valueOf(role);
        this.status = String.valueOf(status);
        this.deletionDate = String.valueOf(deletionDate);
    }
    private String id;
    private String registrationDate;
    private String fullName;
    private String login;
    private String password;
    private String role;
    private String status;
    private String deletionDate;

    public String getId() {
        return id;
    }
    public void setId(Object id) {
        this.id = String.valueOf(id);
    }

    public String getRegistrationDate() {
        return String.valueOf(registrationDate);
    }
    public void setRegistrationDate(Object registrationDate) {
        this.registrationDate = String.valueOf(registrationDate);
    }

    public String getFullName() {
        return String.valueOf(fullName);
    }
    public void setFullName(Object fullName) {
        this.fullName = String.valueOf(fullName);
    }

    public String getLogin() {
        return String.valueOf(login);
    }
    public void setLogin(Object login) {
        this.login = String.valueOf(login);
    }

    public String getPassword() {
        return String.valueOf(password);
    }
    public void setPassword(Object password) {
        this.password = String.valueOf(password);
    }

    public String getRole() {
        return String.valueOf(role);
    }
    public void setRole(Object role) {
        this.role = String.valueOf(role);
    }

    public String getStatus() {
        return String.valueOf(status);
    }
    public void setStatus(Object status) {
        this.status = String.valueOf(status);
    }

    public String getDeletionDate() {
        return String.valueOf(deletionDate).equals("null")? "null": "'"+deletionDate+"'";
    }
    public void setDeletionDate(Object deletionDate) {
        this.deletionDate = String.valueOf(deletionDate);
    }
}
