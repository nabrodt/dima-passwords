package org.example;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.lang.Long.toHexString;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {

        String allowedSigns = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        // System.out.println(allowedSigns.length());

        /**
         * System 1
         *
         * Length: 5 signs
         * allowed signs: uppercase and lowercase latin letters and digits 0 to 9 with repetitions
         * SHA1-hash: 7738d1909d7dee18196f733d0d508d871d05cc8
         */

        long s1_lengthOfSigns = 5;
        long s1_sumOfAllowedSigns = allowedSigns.length();
        // System.out.println(s1_sumOfAllowedSigns);
        // = 62
        long s1_possiblePasswords = (long)pow(s1_sumOfAllowedSigns, s1_lengthOfSigns);
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

        for (int i = 0; i< s1_charArray.length; i++){
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




        /**
         * System 2
         *
         * length: 10 signs
         * allowed signs: uppercase and lowercase latin letters and digits 0 to 9 with repetitions
         * SHA1-hash: e39156538e3e7193fdf6356469fa7414d078f97e
         */

        long s2_lengthOfSigns = 10;
        long s2_sumOfAllowedSigns = allowedSigns.length();
        // System.out.println(s2_sumOfAllowedSigns);
        // = 62
        long s2_possiblePasswords = (long)pow(s2_sumOfAllowedSigns, s2_lengthOfSigns);
        System.out.println(s2_possiblePasswords);
        // 839299365868340224

        String s2_hash = "e39156538e3e7193fdf6356469fa7414d078f97e";


        /**
         * System 3
         *
         * length: 5-10 signs
         *     allowed signs: uppercase and lowercase latin letters and digits 0 to 9 with repetitions
         *     SHA1-hash: 0a3bd07f4152f7f7a9655acfbeb8b4f08bc5861a
         */

        int s3_minLengthOfSigns = 5;
        int s3_maxLengthOfSigns = 10;
        long s3_sumOfAllowedSigns = allowedSigns.length();
        // = 62
        long s3_possiblePasswords = 0;

        for (int i = s3_minLengthOfSigns; i <= s3_maxLengthOfSigns; i++){
            s3_possiblePasswords += (long)pow(s3_sumOfAllowedSigns, i);
        }
        // System.out.println((long)pow(62, 5)+(long)pow(62, 6)+(long)pow(62, 7)+(long)pow(62, 8)+(long)pow(62, 9)+(long)pow(62, 10));
        System.out.println(s3_possiblePasswords);
        // = 853058371851163296

        String s3_hash = "0a3bd07f4152f7f7a9655acfbeb8b4f08bc5861a";

    }





}