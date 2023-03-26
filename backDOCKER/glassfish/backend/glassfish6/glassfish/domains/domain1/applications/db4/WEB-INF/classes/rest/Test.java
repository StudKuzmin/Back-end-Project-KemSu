package rest;


import javax.ws.rs.Path;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import javax.ws.rs.core.Response;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import rest.model.IModel;


@Path("/")
public class Test {
 
 @Inject
 IModel model;
 
 @GET
 @Path("/")
 @Produces("text/plain")
 public String ping() {   
  return "OK";
 } 
 
 
 @POST   
 @Path("/test")
 @Consumes("application/json")
 @Produces("application/json")
 public Response test(String studentsJSON) 
 {            
   Jsonb jsonb = JsonbBuilder.create();          
   List<Student> students;      
   String resultJSON;
   try {  
      try { 
       students = jsonb.fromJson(studentsJSON,new ArrayList<Student>(){}.getClass().getGenericSuperclass());                    
      }
      catch (Exception e) {
        throw new Exception("Error while JSON transforming.");  
      }	  
	  model.run(students);	  	  
	  resultJSON = jsonb.toJson(students);	  	 
   }
   catch (JsonbException e) {
    return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();	             
   }
   catch (Exception e) {
    return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();	             
   }    
   return Response.ok(resultJSON).build();           
 }
 
}