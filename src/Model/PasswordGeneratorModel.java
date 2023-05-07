package Model;

import java.security.SecureRandom;
import java.util.Base64;

public class PasswordGeneratorModel {

    // Method to generate a random password with a specified length
    public String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        String password = Base64.getEncoder().encodeToString(bytes);
        return password.substring(0, length);
    }
}

