package classes.database.entity;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="users.findAll", query="SELECT eu FROM EUser eu"),
        @NamedQuery(name="users.deleteById", query="DELETE FROM EUser where id=:id"),
        @NamedQuery(name="users.updateById", query="UPDATE EUser SET id=:id," +
                "registrationDate=:registrationDate, " +
                "fullName=:fullName, " +
                "login=:login, " +
                "password=:password, " +
                "role=:role, " +
                "status=:status, " +
                "deletionDate=:deletionDate " +
                "WHERE id = :id")
})
@Table(name = "\"users\"")
public class EUser {
    public EUser(){}
    public EUser(int id,
                 String registrationDate,
                 String fullName,
                 String login,
                 String password,
                 String role,
                 String status,
                 String deletionDate){
        this.id = id;
        this.registrationDate = String.valueOf(registrationDate);
        this.fullName = String.valueOf(fullName);
        this.login = String.valueOf(login);
        this.password = String.valueOf(password);
        this.role = String.valueOf(role);
        this.status = String.valueOf(status);
        this.deletionDate = String.valueOf(deletionDate);
    }

    @Id
    @Column(name = "\"id\"")
    public int id;
    @Column(name = "\"registrationDate\"")
    public String registrationDate;
    @Column(name = "\"fullName\"")
    public String fullName;
    @Column(name = "\"login\"")
    public String login;
    @Column(name = "\"password\"")
    public String password;
    @Column(name = "\"role\"")
    public String role;
    @Column(name = "\"status\"")
    public String status;
    @Column(name = "\"deletionDate\"")
    public String deletionDate;
}
