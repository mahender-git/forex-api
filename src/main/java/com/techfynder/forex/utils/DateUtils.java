package com.techfynder.forex.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.Date;

public interface DateUtils {

    public static String convertUtilDateToString(Date date) {
        LocalDateTime now = convertToLocalDateTimeViaInstant(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TechfynderConstants.DD_MMM_YYYY);
        return now.format(formatter);
    }

    public static Date convertStringToDate(final String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(TechfynderConstants.DD_MM_YYYY);
        LocalDate ld = LocalDate.parse(date, df);
        return Date.from(ld.atStartOfDay(ZoneId.of(TechfynderConstants.DEFAULT_TIME_ZONE)).toInstant());
    }

    public static String getCurrentZoneDateInString() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of(TechfynderConstants.DEFAULT_TIME_ZONE));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TechfynderConstants.DD_MMM_YYYY);
        return now.format(formatter);
    }

    public static Date getCurrentZoneDate() {
          LocalDate localDate = LocalDate.now();
          return Date.from(localDate.atStartOfDay(ZoneId.of(TechfynderConstants.DEFAULT_TIME_ZONE)).toInstant());
    }

    public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}
