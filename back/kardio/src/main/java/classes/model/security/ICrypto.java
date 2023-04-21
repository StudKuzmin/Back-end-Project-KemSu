package classes.model.security;

public interface ICrypto {
    public String encrypt(String data) throws Exception;
    public String decrypt(String encryptedString) throws Exception;
}
