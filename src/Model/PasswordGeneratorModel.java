package Model;

import java.security.SecureRandom;
import java.util.Base64;
/*
 * Copyright (c) 2023 Shady Ahmed.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Shady Ahmed. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the license
 * agreement you entered into with Shady Ahmed.
 *
 * Created on May 7, 2023 at 10:30 AM
 */
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

