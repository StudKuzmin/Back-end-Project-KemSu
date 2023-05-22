package classes.controller.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JsonWebToken implements IJsonWebToken {
    private final Algorithm algorithm;

    public JsonWebToken(){
        String secretWord = "kardio";
        algorithm = Algorithm.HMAC256(secretWord);
    }

    public String generateToken(String userId, String tokenType, String role) throws Exception{
        String token = null;
        long expireTime = (new Date().getTime()) + 3600000; // 1 час
        Date expireDate = new Date(expireTime);

        try {
            token = JWT.create()
                    .withIssuer(tokenType)
                    .withClaim("id", userId)
                    .withClaim("role", role)
                    .withExpiresAt(expireDate)
                    .sign(algorithm);

            if(token == null){
                throw new Exception("token is null");
            }

        } catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            throw new Exception();
        }

        return token;
    }
    public boolean checkToken(String token, String tokenType){
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(tokenType)
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);
            return true;

        } catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return false;
        }
    }

    public String getClaimFromToken(String token, String claimKey) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaims().get(claimKey).toString().replace("\"", "");
    }
}
