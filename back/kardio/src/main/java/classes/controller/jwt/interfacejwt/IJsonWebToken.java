package classes.controller.jwt.interfacejwt;

public interface IJsonWebToken {
    public String generateToken(String login, String password, String issuer, String role) throws Exception;
    public boolean checkToken(String token, String issuer);
}
