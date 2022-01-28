package fr.dosi.etron.service.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    private static String datePatter = "yyyy-MM-dd HH:mm:ss";
    private static String datePatternParse = "yyyy-MM-dd'T'HH:mm:ss";

    public static String formateDate(Date date) {
        return formateDate(datePatter, date);
    }

    public static String formateDate(String pattern, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        if (date != null) {
            return simpleDateFormat.format(date);
        } else {
            return "";
        }
    }

    public static Date parse(String date) {
        if (date == null || date.isEmpty()) {
            return null;
        } else {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePatternParse);
                return simpleDateFormat.parse(date);
            } catch (Exception ex) {
                return null;
            }
        }
    }

    public static Date parse(String datePattern, String date) {
        if (date == null || date.isEmpty()) {
            return null;
        } else {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
                return simpleDateFormat.parse(date);
            } catch (Exception ex) {
                return null;
            }
        }
    }

    public static Date parseTimestamp(String date) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(datePatter);
            Date parsedDate = dateFormat.parse(date);
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            return timestamp;
        } catch (Exception e) {
            return null;
        }
    }

    public static Date convert(String date) {
        if (StringUtil.isEmpty(date))
            return null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePatter);
            return simpleDateFormat.parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static Date adaptDate(Date oldDate) {
        if (oldDate != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(oldDate);
            c.add(Calendar.DATE, 1); //same with c.add(Calendar.DAY_OF_MONTH, 1);
            oldDate = c.getTime();
            return oldDate;
        } else return null;

    }

    public static java.sql.Date converte(java.util.Date date) {
        if (date != null) {
            return new java.sql.Date(date.getTime());
        } else {
            return null;
        }
    }

    public static java.sql.Date convertFormUtilToSql(java.util.Date date) {
        if (date != null) {
            return new java.sql.Date(date.getTime());
        } else {
            return null;
        }
    }
}