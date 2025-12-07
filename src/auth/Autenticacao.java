package auth;


public interface Autenticacao {
    boolean autenticar(String login, String senha);
}


// ===== util/PasswordUtils.java =====
package util;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


public final class PasswordUtils {
    private static final SecureRandom RANDOM = new SecureRandom();


    private PasswordUtils() {}


    public static String generateSalt() {
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }


    public static String hashPassword(String senha, String saltBase64) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(Base64.getDecoder().decode(saltBase64));
            byte[] hashed = md.digest(senha.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashed);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Algoritmo de hash não disponível", e);
        }
    }


    public static boolean verifyPassword(String senha, String saltBase64, String expectedHash) {
        String candidate = hashPassword(senha, saltBase64);
        return MessageDigest.isEqual(candidate.getBytes(StandardCharsets.UTF_8), expectedHash.getBytes(StandardCharsets.UTF_8));
    }
}