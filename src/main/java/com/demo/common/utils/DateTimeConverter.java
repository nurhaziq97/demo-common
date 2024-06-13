package com.demo.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static com.demo.common.utils.Constants.*;

@Slf4j
public class DateTimeConverter {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    private DateTimeConverter(){
        throw new IllegalStateException(UTILITY_CLASS);
    }

    /**
     * Check input string is valid or not based on pre-formatted date
     * @param str input date in string
     * @return string convertible to boolean or not
     */
    public static boolean isValidDate(@NonNull String str){
        try {
            DATE_TIME_FORMATTER.parse(str);
        }catch(DateTimeParseException e){
            log.error("Invalid date format for input: {}; Should be in the format: {}", str, DATE_TIME_FORMAT);
            return false;
        }
        return true;
    }

    /**
     * Check input string is valid or not based on the input format
     * @param str input date in string
     * @param format string that contains date pattern to check validation
     * @return input String is a date or not based on the format given
     */
    public static boolean isValidDate(@NonNull String str, @NonNull String format){
        try{
            DateTimeFormatter customDateTimeFormatter = DateTimeFormatter.ofPattern(format);
            customDateTimeFormatter.parse(str);
        }catch(DateTimeParseException | IllegalArgumentException e){
            log.error("Invalid date format for input: {}; Should be in the format: {}", str, format);
            return false;
        }
        return true;
    }

    /**
     * Parse string input to LocalDateTime
     * @param str String input to parse into date
     * @return LocalDateTime of the input string
     */
    public static LocalDateTime parseDate(String str) {
        try {
            return LocalDateTime.parse(str, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            log.error("Error parsing date: {}", str);
            throw e;
        }
    }

    /**
     * Parse date from string to date based on the format given
     * @param str date in string
     * @param format the format of the date
     * @return Date of the string input
     */
    public static LocalDateTime parseDate(String str, String format) {
        try {
            DateTimeFormatter customDateTimeFormatter = DateTimeFormatter.ofPattern(format);
            return LocalDateTime.parse(str, customDateTimeFormatter);
        } catch (DateTimeParseException | IllegalStateException e) {
            log.error("Error parsing date: {}", str);
            throw e;
        }
    }

    /**
     * return date input in string format
     * @param date that will be changed into string
     * @return string of the date
     */
    public static String formatDate(LocalDateTime date) {
        return DATE_TIME_FORMATTER.format(date);
    }

    /**
     * Retrieve current date time
     * @return current date time in the form preset
     */
    public static String getCurrentDateTime(){
        return LocalDateTime.now().format(DATE_TIME_FORMATTER);
    }

    /**
     * Retrieve current date time
     * @return current date time in the form preset
     */
    public static String getCurrentTimestampString(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        return LocalDateTime.now().format(dateTimeFormatter);
    }
}
