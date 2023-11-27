package org.example;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        String start_timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        System.out.println(start_timeStamp + " Start");

        System1 system1 = new System1();
        system1.s1_crackHash();

        // System2 system2 = new System2();
        // system2.s2_crackHash();

        // System3 system3 = new System3();
        // system3.s3_crackHash();

        String end_timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        System.out.println(end_timeStamp + " Ende");

    }

}
