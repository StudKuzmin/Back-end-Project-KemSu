package classes.controller.jwt;

public interface IJsonWebToken {
    public String generateToken(String userId, String tokenType, String role) throws Exception;
    public boolean checkToken(String token, String tokenType);
    public String getClaimFromToken(String token, String claimKey);
}
