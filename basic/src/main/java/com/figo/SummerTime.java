package com.figo;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRules;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

public class SummerTime {
    public static void main(String[] args) {
      test2();
    }

    public  static boolean isDaylightTime(LocalDateTime a,ZoneId dest) {
        ZonedDateTime z1 = a.atZone(dest);
        //或者这样转
//	    	ZonedDateTime z2 = ZonedDateTime.of(a, dest);

        ZoneRules rules = dest.getRules();
        boolean flag= rules.isDaylightSavings(z1.toInstant());
        System.out.println(z1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss "))+flag);
        return flag;
    }

    public static void test1(){
        LocalDateTime a1 = LocalDateTime.now();
        LocalDateTime dt =LocalDateTime.now();
        DateTimeFormatter dfDate = DateTimeFormatter.ofPattern("yyyy-MM-dd E HH:mm:ss",Locale.FRANCE);
        //DateFormat df =DateFormat.getDateInstance(DateFormat.FULL, Locale.FRANCE);
        System.out.println(dfDate.format(dt));
        System.out.println(OffsetDateTime.now().getOffset());
        LocalDateTime a2 = LocalDateTime.of(2023, 12, 1, 1, 59, 59);
        LocalDateTime a3 = LocalDateTime.of(2023, 2, 1, 2, 00);
        LocalDateTime a4 = LocalDateTime.of(2023, 9, 1, 1, 59, 59);
        LocalDateTime a5 = LocalDateTime.of(2023, 4, 1, 2, 0, 0);
//			isDaylightTime(a2);
//			isDaylightTime(a3);
//			isDaylightTime(a4);
//			isDaylightTime(a5);
        a5.atZone(ZoneId.of("Europe/London"));
        System.out.println("=================");
        isDaylightTime(a2, ZoneId.of("Europe/London"));//false
        isDaylightTime(a3, ZoneId.of("Europe/London"));//true
        isDaylightTime(a4, ZoneId.of("Europe/London"));//true
        isDaylightTime(a5, ZoneId.of("Europe/London"));//fasle
    }
    public static void test2(){
        LocalDateTime now = LocalDateTime.now();
        ZoneId currentZone = getZone();
        // 新时区
        ZoneId newZone = ZoneId.of("Europe/London");
        // 时区转换
        System.out.println(now.atZone(currentZone).withZoneSameInstant(newZone).toLocalDateTime());
    }

    public static ZoneOffset getZone() {
        return OffsetDateTime.now().getOffset();
    }
}
