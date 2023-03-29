package classes.controller.jwt.interfacejwt;

public interface IJsonWebToken {
    public String generateToken(int userId, String tokenType, String role) throws Exception;
    public boolean checkToken(String token, String issuer);
}
