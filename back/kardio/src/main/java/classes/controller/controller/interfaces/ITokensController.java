package classes.controller.controller.interfaces;

import jakarta.ws.rs.core.Response;

public interface ITokensController {
    public String refreshToken(String refreshToken) throws Exception;
}
