package classes.controller.JWT;

import classes.controller.JWT.Interface.IJsonWebToken;

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

    public String generateToken(String login, String password, String issuer){
        String token = null;
        long expireTime = (new Date().getTime()) + 3600000;
        Date expireDate = new Date(expireTime);

        try {

            token = JWT.create()
                    .withIssuer(issuer)
                    .withClaim("login", login)
                    .withClaim("password", password)
                    .withExpiresAt(expireDate)
                    .sign(algorithm);

        } catch (Exception ex) { System.out.println("Exception in " + this.getClass().getSimpleName() + ".generateToken(): " + ex.getMessage()); }

        return token;
    }
    public String generateToken(String refreshToken, String issuer){
        String token = null;
        long expireTime = (new Date().getTime()) + 3600000;
        Date expireDate = new Date(expireTime);

        try {

            token = JWT.create()
                    .withIssuer(issuer)
                    .withClaim("refreshToken", refreshToken)
                    .withExpiresAt(expireDate)
                    .sign(algorithm);

        } catch (Exception ex) { System.out.println("Exception in " + this.getClass().getSimpleName() + ".generateToken(): " + ex); }

        return token;
    }
    public boolean checkToken(String token, String issuer){
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build();


            DecodedJWT decodedJWT = verifier.verify(token);
            return true;

        } catch (Exception ex) {
            System.out.println("Exception in " + this.getClass().getSimpleName() + ".checkToken: " + ex);
            return false;
        }
    }
}
