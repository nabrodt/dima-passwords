package org.example;

import java.security.MessageDigest;

import static java.lang.Math.pow;

public class System1 {
    public System1() {

    }

    String allowedSigns = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // System.out.println(allowedSigns.length());

    /**
     * System 1
     * <p>
     * Length: 5 signs
     * allowed signs: uppercase and lowercase latin letters and digits 0 to 9 with repetitions
     * SHA1-hash: 7738d1909d7dee18196f733d0d508d871d05cc8
     */

    long s1_lengthOfSigns = 5;
    long s1_sumOfAllowedSigns = allowedSigns.length();
    // System.out.println(s1_sumOfAllowedSigns);
    // = 62

    public void s1_crackHash() {
        long s1_possiblePasswords = (long) pow(s1_sumOfAllowedSigns, s1_lengthOfSigns);
        System.out.println(s1_possiblePasswords);
        // = 916132832

        String s1_hash = "7738d1909d7dee18196f733d0d508d871d05cc8";

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("sha1");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (messageDigest == null) return;

        char[] s1_charArray = allowedSigns.toCharArray();

        for (int i = 0; i < s1_charArray.length; i++) {
            for (int j = 0; j < s1_charArray.length; j++) {
                for (int k = 0; k < s1_charArray.length; k++) {
                    for (int l = 0; l < s1_charArray.length; l++) {
                        for (int m = 0; m < s1_charArray.length; m++) {
                            String combination = "" + s1_charArray[i] + s1_charArray[j] + s1_charArray[k] + s1_charArray[l] + s1_charArray[m];

                            messageDigest.update(combination.getBytes());
                            byte[] digest = messageDigest.digest();
                            StringBuffer sb = new StringBuffer();
                            for (byte b : digest) {
                                sb.append(String.format("%02x", b & 0xff));
                            }
                            // System.out.println(sb.toString());

                            if (sb.toString().equals(s1_hash)) {
                                System.out.println("Gefunden " + combination);
                            }
                        }

                    }

                }

            }
        }
    }
}
