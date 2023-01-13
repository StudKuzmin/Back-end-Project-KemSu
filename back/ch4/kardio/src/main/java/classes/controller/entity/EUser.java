package classes.controller.entity;

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
        this.id = id;
        this.registrationDate = registrationDate;
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.role = role;
        this.status = status;
        this.deletionDate = deletionDate;
    }
    public String id;
    public String registrationDate;
    public String fullName;
    public String login;
    public String password;
    public String role;
    public String status;
    public String deletionDate;
}
