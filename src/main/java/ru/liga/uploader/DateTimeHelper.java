package ru.liga.uploader;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTimeHelper {
    public static final LocalDate MIN_DATE = LocalDate.of(1901, 1, 1);
    public static final LocalDate MAX_DATE = LocalDate.of(2999, 12, 31);
    public static final LocalDateTime MIN_DATE_TIME = LocalDateTime.of(1901, 1, 1, 0, 0, 0, 0);
    public static final LocalDateTime MAX_DATE_TIME = LocalDateTime.of(2999, 12, 31, 23, 59, 59, 0);

    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final String DATE_TIME_FORMAT = "dd.MM.yyyy HH:mm:ss";

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

    private static final String DEFAULT_ZONE = "Europe/Moscow";
    private static Pattern ddMMyyyy = Pattern.compile("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}");
    private static Pattern yyyyMMdd = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");

    private static Locale locale = Locale.forLanguageTag("ru");

    public static ZoneId getDefaultZoneId() {
        return ZoneId.of(DEFAULT_ZONE);
    }

    public static LocalDateTime asLocalDateTime(Long val) {
        return Instant.ofEpochMilli(val).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDateTime asLocalDateTime(String val) {
        return Instant.ofEpochMilli(Long.parseLong(val)).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDateTime asDefaultLocalDateTime(String val) {
        return Instant.ofEpochMilli(Long.parseLong(val)).atZone(ZoneId.of(DEFAULT_ZONE)).toLocalDateTime();
    }

    public static LocalDate asLocalDate(String val) {
        return asLocalDate(val, ZoneId.systemDefault());
    }

    public static LocalDate asDefaultLocalDate(String val) {
        return asLocalDate(val, ZoneId.of(DEFAULT_ZONE));
    }

    private static LocalDate asLocalDate(String val, ZoneId zone) {
        try {
            DateTimeFormatter formatter = null;

            Matcher matcher = ddMMyyyy.matcher(val);
            if (matcher.find()) {
                val = matcher.group();
                formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            } else {
                matcher = yyyyMMdd.matcher(val);
                if (matcher.find()) {
                    val = matcher.group();
                    formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                }
            }

            if (formatter == null) {
                throw new IllegalArgumentException("Don't know format for text: " + val);
            }
            return LocalDate.parse(val, formatter);
        } catch (Exception ex) {
            return Instant.ofEpochMilli(Long.parseLong(val)).atZone(zone).toLocalDate();
        }
    }

    public static String localDateToString(LocalDate date) {
        int yearValue = date.getYear();
        int monthValue = date.getMonthValue();
        int dayValue = date.getDayOfMonth();
        int absYear = Math.abs(yearValue);
        StringBuilder buf = new StringBuilder(10);

        buf.append(dayValue < 10 ? "0" : "")
                .append(dayValue)
                .append(monthValue < 10 ? ".0" : ".")
                .append(monthValue)
                .append(".");

        if (absYear < 1000) {
            if (yearValue < 0) {
                buf.append(yearValue - 10000).deleteCharAt(1);
            } else {
                buf.append(yearValue + 10000).deleteCharAt(0);
            }
        } else {
            if (yearValue > 9999) {
                buf.append('+');
            }
            buf.append(yearValue);
        }
        return buf.toString();
    }

    public static String getDayAsString(LocalDate date) {
        return String.valueOf(date.getDayOfMonth());
    }

    public static String getMonthAsString(LocalDate date) {
        return String.valueOf(date.getMonth().getDisplayName(TextStyle.FULL, locale));
    }

    public static String getYearAsString(LocalDate date) {
        return String.valueOf(date.getYear());
    }

    public static XMLGregorianCalendar ofXMLGregorianCalendarWithTime(LocalDate localDate) {
        XMLGregorianCalendar xmlGregorianCalendar = ofXMLGregorianCalendar(localDate);
        xmlGregorianCalendar.setTime(0, 0, 0);
        return xmlGregorianCalendar;
    }

    public static XMLGregorianCalendar ofXMLGregorianCalendar(LocalDate localDate) {
        if (localDate == null) return null;
        XMLGregorianCalendar xmlDate;
        try {
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(DateTimeFormatter.ISO_LOCAL_DATE.format(localDate));
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException("Error convert date LocalDate to XMLGregorianCalendar", e);
        }
        return xmlDate;
    }

    public static XMLGregorianCalendar ofXMLGregorianCalendarWithTime(LocalDateTime localDateTime) {
        GregorianCalendar gcal = GregorianCalendar.from(localDateTime.atZone(ZoneId.systemDefault()));
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static XMLGregorianCalendar ofXMLGregorianCalendar(LocalDateTime localDateTime) {
        if (localDateTime == null) return null;
        return ofXMLGregorianCalendar(localDateTime.toLocalDate());
    }

    public static LocalDate ofLocalDate(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar == null) return null;
        return LocalDate.parse(xmlGregorianCalendar.toXMLFormat());
    }

    public static LocalDateTime ofLocalDateTime(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar == null) return null;
        return LocalDateTime.parse(xmlGregorianCalendar.toXMLFormat());
    }

    public static LocalDateTime atEndDay(LocalDateTime dateTime) {
       return dateTime.toLocalDate().atTime(LocalTime.MAX);
    }
}
