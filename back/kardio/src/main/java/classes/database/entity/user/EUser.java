package classes.database.entity.user;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name="users.findAll", query="SELECT eu FROM EUser eu"),
        @NamedQuery(name="users.deleteById", query="DELETE FROM EUser where id=:id"),
        @NamedQuery(name="users.updateById", query="UPDATE EUser SET firstName=:firstName, " +
                "middleName=:middleName, " +
                "lastName=:lastName " +
                "WHERE id = :id"),
        @NamedQuery(name="users.updatePasswordById", query="UPDATE EUser SET password=:password " +
                "WHERE id = :id")
})
@Table(name = "\"users\"")
public class EUser {
    public EUser(){
        this.id = UUID.randomUUID().toString();
    }
    public EUser(String firstName,
                 String middleName,
                 String lastName,
                 String userName,
                 String password,
                 String isDeleted,
                 String createdAt,
                 String updatedAt){
        this.firstName = String.valueOf(firstName);
        this.middleName = String.valueOf(middleName);
        this.lastName = String.valueOf(lastName);
        this.userName = String.valueOf(userName);
        this.password = String.valueOf(password);
        this.isDeleted = String.valueOf(isDeleted);
        this.createdAt = String.valueOf(createdAt);
        this.updatedAt = String.valueOf(updatedAt);
    }

    public void clone(EUser euser){
        euser.id = this.id;
        euser.firstName = this.firstName;
        euser.middleName = this.middleName;
        euser.lastName = this.lastName;
        euser.userName = this.userName;
        euser.password = this.password;
        euser.isDeleted = this.isDeleted;
        euser.createdAt = this.createdAt;
        euser.updatedAt = this.updatedAt;
    }
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "\"id\"")
    public String id;
    @Column(name = "\"firstName\"")
    public String firstName;
    @Column(name = "\"middleName\"")
    public String middleName;
    @Column(name = "\"lastName\"")
    public String lastName;
    @Column(name = "\"userName\"")
    public String userName;
    @Column(name = "\"password\"")
    public String password;
    @Column(name = "\"isDeleted\"")
    public String isDeleted;
    @Column(name = "\"createdAt\"")
    public String createdAt;
    @Column(name = "\"updatedAt\"")
    public String updatedAt;
}
