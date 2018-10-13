package com.nk.common.utils.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


public class DateUtilsTest {

    @Test
    public void timestampToLocalDateTime() {
        LocalDateTime localDateTime = DateUtils.timestampToLocalDateTime(System.currentTimeMillis());
        System.out.println(localDateTime);
    }

    @Test
    public void localDateTimeToString() {
        String localDateTimeToString = DateUtils.localDateTimeToString(LocalDateTime.now(), "yyyyMMdd");
        System.out.println(localDateTimeToString);
    }

    @Test
    public void localDateTimeToTimestamp() {
        long lo = DateUtils.localDateTimeToTimestamp(LocalDateTime.now());
        System.out.println(lo);
    }

    @Test
    public void parseStringToDateTime() {
        LocalDateTime localDateTime = DateUtils.parseStringToDateTime("2018-10-13 00:12:58", "yyyy-MM-dd HH:mm:ss");
        System.out.println(localDateTime);
    }

    @Test
    public void dateToLocalDateTime() {
        LocalDateTime dateToLocalDateTime = DateUtils.dateToLocalDateTime(new Date());
        System.out.println(dateToLocalDateTime);
    }

    @Test
    public void dateToLocalDate() {
        LocalDate localDate = DateUtils.dateToLocalDate(new Date());
        System.out.println(localDate);
    }

    @Test
    public void dateToLocalTime() {
        LocalTime localTime = DateUtils.dateToLocalTime(new Date());
        System.out.println(localTime);
    }

    @Test
    public void localDateTimeToDate() {
        Date localDateTimeToDate = DateUtils.localDateTimeToDate(LocalDateTime.now());
        System.out.println(localDateTimeToDate);
    }

    @Test
    public void localDateToDate() {
        Date localDateToDate = DateUtils.localDateToDate(LocalDate.now());
        System.out.println(localDateToDate);
    }

    @Test
    public void localTimeToDate() {
        Date date = DateUtils.localTimeToDate(LocalTime.now(), LocalDate.now());
        System.out.println(date);
    }

    @Test
    public void withDayOfMonth() {
        LocalDate dayOfMonth = DateUtils.withDayOfMonth(LocalDate.now());
        System.out.println(dayOfMonth);
    }

    @Test
    public void firstInMonthAnyYear() {
        LocalDate localDate = DateUtils.firstInMonthAnyYear("2013-01-01");
        System.out.println(localDate);
    }
}