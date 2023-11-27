package org.example;

import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

import static java.lang.Math.pow;

import java.text.SimpleDateFormat;

public class System1 {
    public System1() {

    }

    String allowedSigns = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // System.out.println(allowedSigns.length());

    /**
     * System 1
     * <p>
     * Length: 5 signs
     * allowed signs: uppercase and lowercase latin letters and digits 0 to 9 with
     * repetitions
     * SHA1-hash: 7738d1909d7dee18196f733d0d508d871d05cc80
     */

    long s1_lengthOfSigns = 5;
    long s1_sumOfAllowedSigns = allowedSigns.length();
    // System.out.println(s1_sumOfAllowedSigns);
    // = 62

    public void s1_crackHash() {
        long s1_possiblePasswords = (long) pow(s1_sumOfAllowedSigns, s1_lengthOfSigns);
        System.out.println(s1_possiblePasswords + " possible passwords");
        // = 916132832

        String s1_hash = "7738d1909d7dee18196f733d0d508d871d05cc80";

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("sha1");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (messageDigest == null)
            return;

        char[] s1_charArray = allowedSigns.toCharArray();
        byte[] combination = {0, 0, 0, 0, 0};
        
        for (int i = 0; i < s1_sumOfAllowedSigns; i++) {
            combination[0] = (byte) s1_charArray[i];
            for (int j = 0; j < s1_sumOfAllowedSigns; j++) {
                combination[1] = (byte) s1_charArray[j];
                for (int k = 0; k < s1_sumOfAllowedSigns; k++) {
                    combination[2] = (byte) s1_charArray[k];
                    for (int l = 0; l < s1_sumOfAllowedSigns; l++) {
                        combination[3] = (byte) s1_charArray[l];
                        for (int m = 0; m < s1_sumOfAllowedSigns; m++) {
                            combination[4] = (byte) s1_charArray[m];

                            // System.out.println(new String(combination, StandardCharsets.UTF_8));
                            // byte[] digest_bytes = messageDigest.digest(combination);

                            if (DigestUtils.sha1Hex(combination).equals(s1_hash)) {
                                String found_timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                                        .format(new java.util.Date());
                                String password = new String(combination);
                                System.out.println(found_timeStamp + " Found " + password);
                                return;
                                // Found MsI42;
                            }
                        }
                    }

                }

            }
        }
    }
}
