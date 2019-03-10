package com.nk.common.utils.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author LK
 */
public final class DateUtils {
    public static LocalDateTime timestampToLocalDateTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    public static String localDateTimeToString(LocalDateTime localDateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

    public static long localDateTimeToTimestamp(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    public static LocalDateTime parseStringToDateTime(String time, String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(time, df);
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    public static LocalTime dateToLocalTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalTime();
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static Date localTimeToDate(LocalTime localTime, LocalDate localDate) {
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    public static LocalDate withDayOfMonth(LocalDate localDate) {
        /**
         * 当月第一天
         */
        //第一天传入1，第二天2，第三天3，第四天4，第五天5,......
        LocalDate dayOfMonth = localDate.withDayOfMonth(2);
        return dayOfMonth;
    }

    public static LocalDate firstInMonthAnyYear(String date) {
        return LocalDate.parse(date).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
    }

    /**
     * 获取 yyyy-MM-dd 00:00:00
     * @param addTime
     * @return
     */
    public static Date getDayStartTimeBy(long addTime) {
        Instant instant = Instant.ofEpochSecond(addTime);
        ZoneId zone = ZoneId.systemDefault();
        instant = localDateToDateTime(instant, zone);
        return Date.from(instant);
    }

    private static Instant localDateToDateTime(Instant instant, ZoneId zone) {
        LocalDate localDate = LocalDateTime.ofInstant(instant, zone).toLocalDate();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.MIN);
        instant = localDateTime.atZone(zone).toInstant();
        return instant;
    }

    /**
     * 获取nextDay yyyy-MM-dd 00:00:00
     * @param addTime
     * @return
     */
    public static Date getNextDayStartTimeBy(long addTime) {
        Instant instant = Instant.ofEpochSecond(addTime);
        ZoneId zone = ZoneId.systemDefault();
        instant = nextLocalDateToDateTime(instant, zone);
        return Date.from(instant);
    }

    private static Instant nextLocalDateToDateTime(Instant instant, ZoneId zone) {
        LocalDate localDate = LocalDateTime.ofInstant(instant, zone).toLocalDate().plusDays(1);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.MIN);
        instant = localDateTime.atZone(zone).toInstant();
        return instant;
    }

    /**
     * 获取 yyyy-MM-dd 00:00:00
     * @param addTime
     * @return
     */
    public static Date getDayStartTimeBy(Date addTime) {
        Instant instant = addTime.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        instant = localDateToDateTime(instant, zone);
        return Date.from(instant);
    }

    /**
     * 获取nextDay yyyy-MM-dd 00:00:00
     * @param addTime
     * @return
     */
    public static Date getNextDayStartTimeBy(Date addTime) {
        Instant instant = addTime.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        instant = nextLocalDateToDateTime(instant, zone);
        return Date.from(instant);
    }
}
