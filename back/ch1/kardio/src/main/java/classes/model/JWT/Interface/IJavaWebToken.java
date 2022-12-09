package classes.model.JWT.Interface;

public interface IJavaWebToken {
    public String generateToken(String login, String password);
    public boolean checkToken(String token);
}
