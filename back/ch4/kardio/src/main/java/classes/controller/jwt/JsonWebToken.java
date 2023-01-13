package classes.controller.jwt;

import classes.controller.jwt.interfacejwt.IJsonWebToken;

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

    public String generateToken(String login, String password, String issuer, String role){
        String token = null;
        long expireTime = (new Date().getTime()) + 3600000;
        Date expireDate = new Date(expireTime);

        try {

            token = JWT.create()
                    .withIssuer(issuer)
                    .withClaim("login", login)
                    .withClaim("password", password)
                    .withClaim("role", role)
                    .withExpiresAt(expireDate)
                    .sign(algorithm);

        } catch (Exception ex) { System.out.println("ERROR in " + this.getClass().getSimpleName() + ".generateToken: " + ex.getMessage()); }

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
            System.out.println("ERROR in " + this.getClass().getSimpleName() + ".checkToken: " + ex);
            return false;
        }
    }

    public String getClaimFromToken(String token, String claimKey) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaims().get(claimKey).toString().replace("\"", "");
    }
}
