package classes.model.JWT;

import classes.model.JWT.Interface.IJavaWebToken;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JavaWebToken implements IJavaWebToken {
    private final Algorithm algorithm;

    public JavaWebToken(){
        String secretWord = "kardio";
        algorithm = Algorithm.HMAC256(secretWord);
    }

    public String generateToken(String login, String password){
        String token = null;

        try {

            token = JWT.create()
                    .withIssuer("JWT")
                    .withClaim("login", login)
                    .withClaim("password", password)
                    .withExpiresAt(new java.util.Date(new java.util.Date().getTime() + 86400000)) // 1 day
                    .sign(algorithm);

        } catch (Exception ex) { System.out.println("Exception in " + this.getClass().getSimpleName() + ".generateToken(): " + ex.getMessage()); }

        return token;
    }
    public boolean checkToken(String token){
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("JWT")
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);
            return true;

        } catch (Exception ex) {
            System.out.println("Exception in " + this.getClass().getSimpleName() + ".checkToken(): " + ex.getMessage());
            return false;
        }
    }
}
