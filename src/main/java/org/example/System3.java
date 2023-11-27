package org.example;

import static java.lang.Math.pow;

public class System3 {

    String allowedSigns = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // System.out.println(allowedSigns.length());

    /**
     * System 3
     * <p>
     * length: 5-10 signs
     * allowed signs: uppercase and lowercase latin letters and digits 0 to 9 with repetitions
     * SHA1-hash: 0a3bd07f4152f7f7a9655acfbeb8b4f08bc5861a
     */

    int s3_minLengthOfSigns = 5;
    int s3_maxLengthOfSigns = 10;
    long s3_sumOfAllowedSigns = allowedSigns.length();
    // = 62

    public void s3_crackHash() {
        long s3_possiblePasswords = 0;

        for(int i = s3_minLengthOfSigns; i <=s3_maxLengthOfSigns; i++) {
            s3_possiblePasswords += (long) pow(s3_sumOfAllowedSigns, i);
        }
        // System.out.println((long)pow(62, 5)+(long)pow(62, 6)+(long)pow(62, 7)+(long)pow(62, 8)+(long)pow(62, 9)+(long)pow(62, 10));
        System.out.println(s3_possiblePasswords);
        // = 853058371851163296

        String s3_hash = "0a3bd07f4152f7f7a9655acfbeb8b4f08bc5861a";

    }

}
