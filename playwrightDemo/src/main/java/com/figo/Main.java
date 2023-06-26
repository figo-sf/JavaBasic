package com.figo;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main2(String[] args) {
        LocalDateTime dt =LocalDateTime.now();
        DateTimeFormatter dfDate = DateTimeFormatter.ofPattern("yyyy-MM-dd E 00:00:00",Locale.FRANCE);
        DateFormat df =DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE);
        System.out.println(dfDate.format(dt.toLocalDate()));

    }

    public static void main(String[] args) {
        double lat =100.120111;
        double dLat = (double) Math.round(lat * 1000) / 1000;
        System.out.println(dLat);

    }
}