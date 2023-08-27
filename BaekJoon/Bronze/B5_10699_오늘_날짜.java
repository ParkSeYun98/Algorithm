package BaekJoon.Bronze;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class B5_10699_오늘_날짜 {
    public static void main(String[] args) {
        Date now = new Date();

        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");

        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

        System.out.printf(dateFormat.format(now));
    }
}
