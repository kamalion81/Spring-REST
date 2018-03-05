package com.mycompany.spring.rest;

import java.util.Properties;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.exolab.castor.mapping.ValidityException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Класс -  обработчик значения полей с типом DateTime
 * @author kamalion
 */
public class DateTimeFieldHandler extends GeneralizedFieldHandler {
    private static String dateFormatPattern;

    @Override
    public void setConfiguration(Properties config) throws ValidityException {
        dateFormatPattern = config.getProperty("date-format");
    }

    /**
     * Преобразовывает значение DateTime в String
     * @param value значение
     * @return строковое представление
     */
    @Override
    public Object convertUponGet(Object value) {
        DateTime dateTime = (DateTime) value;

        return format(dateTime);
    }

    /**
     * Преобразовывает значение String в DateTime
     * @param value значение    
     * @return значение в виде DateTime
     */
    @Override
    public Object convertUponSet(Object value) {
        String dateTimeString = (String) value;

        return parse(dateTimeString);
    }

    @Override
    public Class<DateTime> getFieldType() {
        return DateTime.class;
    }

    protected static String format(final DateTime dateTime) {
        String dateTimeString = "";

        if (dateTime != null) {
            DateTimeFormatter dateTimeFormatter =
                    DateTimeFormat.forPattern(dateFormatPattern);
            dateTimeString = dateTimeFormatter.print(dateTime);
        }

        return dateTimeString;
    }

    protected static DateTime parse(final String dateTimeString) {
        DateTime dateTime = new DateTime();

        if (dateTimeString != null) {
            DateTimeFormatter dateTimeFormatter =
                    DateTimeFormat.forPattern(dateFormatPattern);
            dateTime = dateTimeFormatter.parseDateTime(dateTimeString);
        }

        return dateTime;
    }
}
