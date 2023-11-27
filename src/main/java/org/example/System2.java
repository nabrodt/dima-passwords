package org.example;

import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

import static java.lang.Math.pow;

import java.text.SimpleDateFormat;

public class System2 {

    String allowedSigns = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // System.out.println(allowedSigns.length());

    /**
     * System 2
     * <p>
     * length: 10 signs
     * allowed signs: uppercase and lowercase latin letters and digits 0 to 9 with
     * repetitions
     * SHA1-hash: e39156538e3e7193fdf6356469fa7414d078f97e
     */

    long s2_lengthOfSigns = 10;
    long s2_sumOfAllowedSigns = allowedSigns.length();
    // System.out.println(s2_sumOfAllowedSigns);
    // = 62

    public void s2_crackHash() {
        long s2_possiblePasswords = (long) pow(s2_sumOfAllowedSigns, s2_lengthOfSigns);
        System.out.println(s2_possiblePasswords);
        // 839299365868340224

        String s2_hash = "e39156538e3e7193fdf6356469fa7414d078f97e";

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("sha1");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (messageDigest == null)
            return;

        char[] s2_charArray = allowedSigns.toCharArray();
        byte[] combination = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        for (int i = 0; i < s2_sumOfAllowedSigns; i++) {
            combination[0] = (byte) s2_charArray[i];
            for (int j = 0; j < s2_sumOfAllowedSigns; j++) {
                combination[1] = (byte) s2_charArray[j];
                for (int k = 0; k < s2_sumOfAllowedSigns; k++) {
                    combination[2] = (byte) s2_charArray[k];
                    for (int l = 0; l < s2_sumOfAllowedSigns; l++) {
                        combination[3] = (byte) s2_charArray[l];
                        for (int m = 0; m < s2_sumOfAllowedSigns; m++) {
                            combination[4] = (byte) s2_charArray[m];
                            for (int n = 0; n < s2_sumOfAllowedSigns; n++) {
                                combination[5] = (byte) s2_charArray[n];
                                for (int o = 0; o < s2_sumOfAllowedSigns; o++) {
                                    combination[6] = (byte) s2_charArray[o];
                                    for (int p = 0; p < s2_sumOfAllowedSigns; p++) {
                                        combination[7] = (byte) s2_charArray[p];
                                        for (int q = 0; q < s2_sumOfAllowedSigns; q++) {
                                            combination[8] = (byte) s2_charArray[q];
                                            for (int r = 0; r < s2_sumOfAllowedSigns; r++) {
                                                combination[9] = (byte) s2_charArray[r];

                                                // System.out.println(new String(combination, StandardCharsets.UTF_8));
                                                // byte[] digest_bytes = messageDigest.digest(combination);

                                                if (DigestUtils.sha1Hex(combination).equals(s2_hash)) {
                                                    String found_timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                                                            .format(new java.util.Date());
                                                    String password = new String(combination);
                                                    System.out.println(found_timeStamp + " Found " + password);
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }

                            }

                        }
                    }

                }

            }
        }

    }

}