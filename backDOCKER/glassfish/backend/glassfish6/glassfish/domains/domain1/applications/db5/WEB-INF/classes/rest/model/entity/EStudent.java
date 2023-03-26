package rest.model.entity;

import java.io.Serializable;

   
//JPA (Begin)
import javax.persistence.*;
//JPA (End)   
  

@Entity
@Table(name = "\"students\"")
public class EStudent implements Serializable
{
  @Id
  @Column(name = "\"id\"")
  private Integer studentID;
  @Column(name = "\"name\"")
  private String studentName;
  
  public Integer getStudentID() {
    return studentID;
  }
  
  public void setStudentID(Integer sID) {
    studentID = sID;
  }  
  
  public String getStudentName() {
    return studentName;
  }
  
  public void setStudentName(String sName) {
    studentName = sName;
  }
}