package com.chestnut.aigc.likou;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Test1 {
    public static void main(String[] args) {
        String dateTime = "2025-02-01";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate requestDateTime = LocalDate.parse(dateTime, dateTimeFormatter);
        LocalDate requestDateSunday = requestDateTime.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));

        LocalDate today = LocalDate.now();
        LocalDate nowTimeSunday = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));

        long between = ChronoUnit.WEEKS.between(requestDateSunday, nowTimeSunday);

        System.out.println(between);
    }
}
