package com.figo.javabaisc.date;

/**
 * Created by 50245 on 2017/6/29.
 */

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws Exception {
        Date start = new SimpleDateFormat("yyy-MM-dd").parse("2008-08-29");
        Date end = new SimpleDateFormat("yyy-MM-dd").parse("2008-09-02");
        while (start.getTime() <= end.getTime()) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(start));
            start = new Date(start.getTime() + 86400000);
        }

        DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(dateTime.toDate()));
        System.out.println(dateTime.plusDays(90).toString("E MM/dd/yyyy HH:mm:ss.SSS"));
        System.out.println(dateTime.plusDays(45).plusMonths(1).dayOfWeek()
                .withMaximumValue().toString("E MM/dd/yyyy HH:mm:ss.SSS"));

        DateTime dateTime2 = new DateTime(new Date());
        System.out.println(dateTime2.toString("MM/dd/yyyy hh:mm:ss.SSSa"));
        dateTime2.toString("dd-MM-yyyy HH:mm:ss");
        dateTime2.toString("EEEE dd MMMM, yyyy HH:mm:ssa");
        dateTime2.toString("MM/dd/yyyy HH:mm ZZZZ");
        dateTime2.toString("MM/dd/yyyy HH:mm Z");
    }
}
