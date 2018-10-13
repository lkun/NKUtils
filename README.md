# NKUtils
Java常用工具备忘

> 在平常时开发过程中，总有很多奇奇怪怪的时间需要互相转换，比如 Date to String , Date to DateTime , String to Date , String to DateTime ,Date to TimeStamp等等......,中间就算对JavaApi再熟悉也难免会搞混，还不如做一些简单的记录，方便日后需要用到之时直接复制出来使用即可。

## LocalDateTime to String(将LocalDateTime 转为自定义的时间格式字符串

```
public static String localDateTimeToString(LocalDateTime localDateTime, String format) 
{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
    return localDateTime.format(formatter);
}
```

<!-- more -->

## timestamp to LocalDateTime(将long类型的timeStamp转为LocalDateTime)

```
public static LocalDateTime timestampToLocalDateTime(long timestamp) 
{
    Instant instant = Instant.ofEpochMilli(timestamp);
    ZoneId zone = ZoneId.systemDefault();
    return LocalDateTime.ofInstant(instant, zone);
}
```


## LocalDateTime to timestamp(将LocalDateTime转为long类型的timeStamp)

```
public static long localDateTimeToTimestamp(LocalDateTime localDateTime) 
{
    ZoneId zone = ZoneId.systemDefault();
    Instant instant = localDateTime.atZone(zone).toInstant();
    return instant.toEpochMilli();
}
```

## LocalDateTime to Date(将LocalDateTime to Date)

```
public static Date localDateTimeToDate(LocalDateTime localDateTime) 
{
    ZoneId zone = ZoneId.systemDefault();
    Instant instant = localDateTime.atZone(zone).toInstant();
    return Date.from(instant);
}
```


## String to 自定义格式(Formatter)的LocalDateTime(将时间字符串转为自定义格式的LocalDateTime)

```
public static LocalDateTime parseStringToDateTime(String time, String format) 
{
    DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
    return LocalDateTime.parse(time, df);
}
```

## Date to LocalDateTime(将Date转为LocalDateTime)

```
public static LocalDateTime dateToLocalDateTime(Date date) 
{
    Instant instant = date.toInstant();
    ZoneId zone = ZoneId.systemDefault();
    return LocalDateTime.ofInstant(instant, zone);
}
```


## Date to LocalDate（将Date 转为 LocalDate）

```
public static LocalDate dateToLocalDate(Date date) 
{
    Instant instant = date.toInstant();
    ZoneId zone = ZoneId.systemDefault();
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
    return localDateTime.toLocalDate();
}
```

## LocalDate to Date

```
public static Date localDateToDate(LocalDate localDate) 
{
    ZoneId zone = ZoneId.systemDefault();
    Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
    return Date.from(instant);
}
```

## Date to LocalTime(将 Date 转为 LocalTime)

```
public static LocalTime dateToLocalTime(Date date) 
{
    Instant instant = date.toInstant();
    ZoneId zone = ZoneId.systemDefault();
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
    return localDateTime.toLocalTime();
}
```

## LocalTime to Date

```
public static Date localTimeToDate(LocalTime localTime , LocalDate localDate) 
{
    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
    ZoneId zone = ZoneId.systemDefault();
    Instant instant = localDateTime.atZone(zone).toInstant();
    return Date.from(instant);
}
```

## 获取任意日期

```
public static LocalDate anyDay(LocalDate localDate) 
{
    /**
        * 当月第一天-写法1
        */
    //第一天传入1，第二天2，第三天3，第四天4，第五天5,......
    LocalDate dayOfMonth = localDate.withDayOfMonth(2);
    /**
        * 当月第一天-写法2
        */
    LocalDate with = localDate.with(TemporalAdjusters.firstDayOfMonth());
    //当月最后一天
    LocalDate lastDate = localDate.with(TemporalAdjusters.lastDayOfMonth());

    //下一天
    LocalDate plusDays = dayOfMonth.plusDays(1);
    //前一天
    LocalDate minusDays = dayOfMonth.minusDays(1);

    // 取2014年1月第一个周一
    LocalDate firstMondayOf2014 = LocalDate.parse("2014-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

    return dayOfMonth;
}
```
