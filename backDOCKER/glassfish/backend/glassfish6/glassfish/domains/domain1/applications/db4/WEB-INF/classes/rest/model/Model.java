package rest.model;

import rest.model.entity.EStudent;
import rest.Student;



import java.util.List;

//JDBC (Begin)
import java.sql.*;
//JDBC (End)

//Pool (Begin)
import javax.annotation.Resource;   
import javax.sql.DataSource;
   
import javax.naming.InitialContext;   
//Pool (End)   


//JPA (Begin)
import javax.persistence.*;
import javax.transaction.*;
//JPA (End)   


public class Model implements IModel  {

    //Pool (Begin)
    //@Resource(name = "jdbc/local_pg_test")
    private DataSource ds;
    //Pool (End)   

	//JPA (Begin)
	@PersistenceUnit(unitName = "local_pg_test_PersistenceUnit")
    private EntityManagerFactory entityManagerFactory;
   
    @Resource
    private UserTransaction userTransaction;
	//JPA (End)   
	
	
   	private int retrieveRowsCountBySimpleJDBC() throws Exception {				
		try 
		{			
            Class.forName("org.postgresql.Driver");            
			String url = "jdbc:postgresql://localhost:5432/jee_test";
            String login = "jee";
            String password = "123456";			
            Connection con = DriverManager.getConnection(url, login, password);			
            try 
			{
                Statement stmt = con.createStatement();                			
				ResultSet rs = stmt.executeQuery("SELECT * FROM \"students\"");								
				int count = 0;
                while (rs.next()) {                
					//String str = rs.getString("id") + " " + rs.getString("name");                
					count++;
                }				
                rs.close();
                stmt.close();				
				return count;
            } finally {
                con.close();
            }			
        } 
		catch (Exception e) 
		{
            throw new Exception("Error while JDBC operating: " + e.getMessage());
        }
	}  
	
	
    private int retrieveRowsCountByPoolConnection() throws Exception {				
		try 
		{			            
		    try {	        
	         InitialContext initialContext = new InitialContext();
             ds = (DataSource) initialContext.lookup("jdbc/local_pg_test");
	        }	
	        catch(Exception e) {	        		      
		      throw new Exception("Error while Data Source initializing: " + e.getMessage());
	        }
			
            Connection con = ds.getConnection();		  
            try 
			{
                Statement stmt = con.createStatement();                			
				ResultSet rs = stmt.executeQuery("SELECT * FROM \"students\"");								
				int count = 0;
                while (rs.next()) {                
					//String str = rs.getString("id") + " " + rs.getString("name");                
					count++;
                }				
                rs.close();
                stmt.close();				
				return count;
            } finally {
                con.close();
            }			
        } 
		catch (Exception e) 
		{
            throw new Exception("Error while JDBC operating: " + e.getMessage());
        }
	}
	
	
	private int retrieveRowsCountByJPA() throws Exception {	   
	   EntityManager entityManager;
	   try {
	      entityManager = entityManagerFactory.createEntityManager();
	   }
       catch (Exception e) {
		  throw new Exception("Error while Entity Manager initializing: " + e.getMessage()); 
	   }	   
	          
       try {
         userTransaction.begin();
         entityManager.joinTransaction();
		 
		 List<EStudent> students = entityManager.createQuery("SELECT s FROM EStudent s",EStudent.class).getResultList();                                                                                                   		 		 
		 
		 /*
         EStudent studentFind = entityManager.find(EStudent.class,new Integer(2));		 
		 studentFind.setStudentName("Student_Find");
		 entityManager.merge(studentFind);
		 
		 EStudent studentPersist = new EStudent();
		 studentPersist.setStudentID(new Integer(3));
		 studentPersist.setStudentName("Student_Persist");		 
		 entityManager.persist(studentPersist);
		 */
		 
         userTransaction.commit();
		 
		 
		 return students.size(); 
       }
	   catch (Exception e) {
         throw new Exception("Error while JPA operating: " + e.getMessage());
       }	   
   }
	

	private int retrieveRowsCount() throws Exception {	
	    //return 1*retrieveRowsCountBySimpleJDBC();
		//return 2*retrieveRowsCountByPoolConnection();
		return 3*retrieveRowsCountByJPA();
	}	
	   
    public void run(List<Student> students) throws Exception {
	   int count = retrieveRowsCount();	
       for (Student student : students ) {
		 student.setId((student.getId()) + count);		  		 		 		 
      }
    } 
}


/*
package com.corejsf;

import java.io.Serializable;
import javax.inject.Named; 
   // or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped; 
   // or import javax.faces.bean.SessionScoped;

//DB Pool (Begin)
import java.sql.*;
import javax.annotation.Resource;   
import javax.sql.DataSource;
   
import javax.naming.InitialContext;   
//DB Pool (End)   
   
//JPA (Begin)
import javax.persistence.*;
import javax.transaction.*;
//JPA (End)   
 
import com.corejsf.Student;
   
@Named("user") // or @ManagedBean(name="user")
@SessionScoped
public class UserBean implements Serializable {
   private String name;
   private String password;
   
   //@Resource(name = "jdbc/pgsql")
   private DataSource ds;
   
   
   @PersistenceUnit(unitName = "studentPersistenceUnit")
   private EntityManagerFactory entityManagerFactory;
   
   @Resource
   private UserTransaction userTransaction;
   
   
   public String getName() { return name; }   
   public void setName(String newValue) { name = newValue; }

   public String getPassword() { return password; }
   public void setPassword(String newValue) { password = newValue; }   
   
   
   public String getTest() {	   
	   String res = "";
	   
	   try
	   {
	    InitialContext initialContext = new InitialContext();
        ds = (DataSource) initialContext.lookup("jdbc/pgsql");
	   }	
	   catch(Exception e)
	   {
		 res = "JNDI: " + e.getMessage();  
		 return res;
	   }
	   
	   try
	   {
		  Connection con = ds.getConnection();		  
          try 
	      {
                Statement stmt = con.createStatement();                				
				ResultSet rs = stmt.executeQuery("SELECT * FROM \"Students\"");								
				
                while (rs.next()) {                    
					res = res + rs.getString("Student_ID") + " " + rs.getString("Student_Name");                    
                }				
                rs.close();
                stmt.close();				
          }		  
		  catch (Exception e)
		  {
			 res = "Process error: " + e.getMessage();
		  }
		  finally
		  {
                con.close();
          }
          
	   }
	   catch (Exception e)
	   {
		   res = "Connection error: " + e.getMessage();
	   }
	   
	   return res;		  
   }
   
   
   public String getTest2() {
	   String res = "";
	   
	   EntityManager entityManager;
	   try {
	      entityManager = entityManagerFactory.createEntityManager();
	   }
       catch (Exception e) {
		 res = "EntityManager: " + e.getMessage();  
		 return res;
	   }	   
	          
       try {
         userTransaction.begin();
         entityManager.joinTransaction();
         Student studentFind = entityManager.find(Student.class,new Integer(2));
		 res = "" + studentFind.getStudentName();
		 res = "" + userTransaction;
		 studentFind.setStudentAdd(new Integer(2222));		 
		 entityManager.merge(studentFind);
		 Student studentPersist = new Student();
		 studentPersist.setStudentID(new Integer(3));
		 studentPersist.setStudentName("Student_3");
		 studentPersist.setStudentAdd(new Integer(33));		 
		 entityManager.persist(studentPersist);
         userTransaction.commit();
       }
	   catch (Exception e) {
         res = "JPA: " + e.getMessage(); 
       }
	   return res;
   }
   
}
*/