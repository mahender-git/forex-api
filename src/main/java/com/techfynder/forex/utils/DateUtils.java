package com.techfynder.forex.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public interface DateUtils {

    public static final AtomicInteger count = new AtomicInteger(0);

    public static String convertUtilDateToString(Date date,final String format) {
        LocalDateTime now = convertToLocalDateTimeViaInstant(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return now.format(formatter);
    }

    public static Date convertStringToDate(final String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(TechfynderConstants.DD_MM_YYYY);
        LocalDate ld = LocalDate.parse(date, df);
        return Date.from(ld.atStartOfDay(ZoneId.of(TechfynderConstants.DEFAULT_TIME_ZONE)).toInstant());
    }

    public static String getCurrentZoneDateInString(final String format) {
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

    public static String generateSequenceKey() {
       String date = convertUtilDateToString(new Date(),TechfynderConstants.SEQUENCE_TIMESTAMP_FORMAT);
        BigDecimal bigDecimalDate = new BigDecimal(date);
        String sequenceId = TechfynderConstants.CURRENT_INSTANCE_ID + String.valueOf(bigDecimalDate) + String.valueOf(count.incrementAndGet());
        return sequenceId;
    }
}
