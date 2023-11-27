package org.example;

import java.security.MessageDigest;

import static java.lang.Math.pow;

public class System2 {

    String allowedSigns = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // System.out.println(allowedSigns.length());

    /**
     * System 2
     * <p>
     * length: 10 signs
     * allowed signs: uppercase and lowercase latin letters and digits 0 to 9 with repetitions
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

        MessageDigest s2_messageDigest = null;
        try {
            s2_messageDigest = MessageDigest.getInstance("sha1");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (s2_messageDigest == null) return;

        char[] s2_charArray = allowedSigns.toCharArray();

        for (int i = 0; i < s2_charArray.length; i++) {
            for (int j = 0; j < s2_charArray.length; j++) {
                for (int k = 0; k < s2_charArray.length; k++) {
                    for (int l = 0; l < s2_charArray.length; l++) {
                        for (int m = 0; m < s2_charArray.length; m++) {
                            for (int n = 0; n < s2_charArray.length; n++) {
                                for (int o = 0; o < s2_charArray.length; o++) {
                                    for (int p = 0; p < s2_charArray.length; p++) {
                                        for (int q = 0; q < s2_charArray.length; q++) {
                                            for (int r = 0; r < s2_charArray.length; r++) {
                                                String s2_combination = "" + s2_charArray[i] + s2_charArray[j] + s2_charArray[k] + s2_charArray[l] + s2_charArray[m] + s2_charArray[n] + s2_charArray[o] + s2_charArray[p] + s2_charArray[q] + s2_charArray[r];

                                                s2_messageDigest.update(s2_combination.getBytes());
                                                byte[] digest = s2_messageDigest.digest();
                                                StringBuffer s2_sb = new StringBuffer();
                                                for (byte b : digest) {
                                                    s2_sb.append(String.format("%02x", b & 0xff));
                                                }
                                                // System.out.println(s2_sb.toString());

                                                if (s2_sb.toString().equals(s2_hash)) {
                                                    System.out.println("Gefunden " + s2_combination);
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