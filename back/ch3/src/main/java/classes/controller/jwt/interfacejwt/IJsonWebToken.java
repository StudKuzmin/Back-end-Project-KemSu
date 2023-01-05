package classes.controller.jwt.interfacejwt;

public interface IJsonWebToken {
    public String generateToken(String login, String password, String issuer);
    public boolean checkToken(String token, String issuer);
}
