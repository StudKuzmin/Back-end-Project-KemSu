package classes.database.entity;

public class EError {

    public EError(){

    }
    public EError(String message, int statusCode){
        this.message = message;
        this.statusCode = statusCode;
    }
    public String message;
    public int statusCode;
}
