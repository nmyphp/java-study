package com.free.jdk.newfuture.jdk8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Date新特性
 * <p>LocalDateTime + DateTimeFormatter是替代Date + SimpleDateFormat的方案，
 * 混用并不是推荐的做法（也可能行不通），那样会使代码更复杂</p>
 */
class DateDemo {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("2018-06-08");
        String dateString = localDate.format(DateTimeFormatter.ISO_DATE);
        System.out.println(dateString);

        LocalTime localTime = LocalTime.of(14, 38, 10);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        String datetimeString = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(datetimeString);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String customDataTimeString = localDateTime.format(dateTimeFormatter);
        System.out.println(customDataTimeString);
    }

}

