package com.figo.javabaisc.date;

/**
 * Created by 50245 on 2017/6/29.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws Exception {
        Date start = new SimpleDateFormat("yyy-MM-dd").parse("2008-08-29");
        Date end = new SimpleDateFormat("yyy-MM-dd").parse("2008-09-02");

//        start = new Date(start.getTime() + 86400000);

        while (start.getTime() <= end.getTime()) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(start));
            start = new Date(start.getTime() + 86400000);
        }

    }
}
