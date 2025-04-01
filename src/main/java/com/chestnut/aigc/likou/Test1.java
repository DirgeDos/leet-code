package com.chestnut.aigc.likou;

import org.springframework.util.StringUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate localDate = LocalDate.now().plusYears(-1L);
        long between = ChronoUnit.DAYS.between(localDate, today);
        System.out.println(between);

        String x = "1 2 3 ";
        String s = StringUtils.trimAllWhitespace(x);
        System.out.println(s);
    }
}
