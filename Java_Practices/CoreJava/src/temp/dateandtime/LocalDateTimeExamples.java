package temp.dateandtime;

import temp.dateandtime.constants.Constants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class LocalDateTimeExamples {

    /**
     * this method contains various ways to initiate localDateTime object.
     */
    static void localDateTimeConstructorExample(){

        LocalDateTime currentDateTime = LocalDateTime.now();

        LocalDateTime dateTime = LocalDateTime.of(2022, 4, 18, 14, 30, 45);

        String dateTimeString = "2022-04-18T14:30:45";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, formatter);

    }

    /**
     * this method contains various ways to initiate localDate object.
     */
    static void localDateConstructorExample(){

        LocalDate currentDate = LocalDate.now();


        LocalDate date = LocalDate.of(2022, 4, 18);


        String dateString = "2022-04-18";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formattedDate = LocalDate.parse(dateString, formatter);


        LocalDate ofYearDay = LocalDate.ofYearDay(2022, 108);


        LocalDate epochDay = LocalDate.ofEpochDay(18760); // Represents January 1, 2022


    }


    /**
     * this method prints today , yesterday and tomorrow date.
     */
    static void localDateExampleOne(){

        System.out.println("this method prints today , yesterday and tomorrow date.");

        LocalDate date = LocalDate.now();
        LocalDate yesterday = date.minusDays(1);
        LocalDate tomorrow = yesterday.plusDays(2);
        System.out.println("Today date: "+date);
        System.out.println("Yesterday date: "+yesterday);
        System.out.println("Tomorrow date: "+tomorrow);

        System.out.println(Constants.METHOD_SEPARATOR);

    }

    /**
     * this method demonstrates the use of isLeapYear() method of LocalDate.
     */
    static void localDateExampleTwo(){

        System.out.println("this method demonstrates the use of isLeapYear() method of LocalDate.");

        LocalDate date1 = LocalDate.of(2017, 1, 13);
        System.out.println(date1.isLeapYear());
        LocalDate date2 = LocalDate.of(2016, 9, 23);
        System.out.println(date2.isLeapYear());

        System.out.println(Constants.METHOD_SEPARATOR);
    }

    /**
     * this method demonstrates the use of atTime method of LocalDateTime.
     */
    static void localDateExampleThree(){

        System.out.println("this method demonstrates the use of atTime method of LocalDateTime.");

        LocalDate date = LocalDate.of(2017, 1, 13);
        LocalDateTime datetime = date.atTime(1,50,9);

        System.out.println(datetime);
        System.out.println(datetime.minusDays(3));

        System.out.println(Constants.METHOD_SEPARATOR);

    }


    /**
     * this method demonstrates the use of DateTimeFormatter.
     */
    static void localDateExampleFour(){

        System.out.println("converting localDate to string");

        // Converting LocalDate to String
        // Example 1
        LocalDate d1 = LocalDate.now();
        String d1Str = d1.format(DateTimeFormatter.ISO_DATE);
        System.out.println("Date1 in string :  " + d1Str);


        // Example 2
        LocalDate d2 = LocalDate.of(2002, 05, 01);
        String d2Str = d2.format(DateTimeFormatter.ISO_DATE);
        System.out.println("Date2 in string :  " + d2Str);


        // Example 3
        LocalDate d3 = LocalDate.of(2016, 11, 01);
        String d3Str = d3.format(DateTimeFormatter.ISO_DATE);
        System.out.println("Date3 in string :  " + d3Str);

        System.out.println(Constants.METHOD_SEPARATOR);

    }


    /**
     * this method shows us how we can print custom date string.
     */
    static void localDateExampleFive(){

        System.out.println("this method shows us how we can print custom date string.");

        // Create a LocalDateTime object representing the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Create a custom date format using the ofPattern() method
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ss");

        // Format the LocalDateTime object using the custom date format
        String formattedDateTime = now.format(formatter);

        // Display the result
        System.out.println("Formatted date and time: " + formattedDateTime);


        System.out.println(Constants.METHOD_SEPARATOR);

    }


    /**
     * this method show us how we can print customized date string.
     */
    static void localDateExampleSix(){

        System.out.println("this method show us how we can print customized date string.");

//        LocalDate localDate = LocalDate.now();
//
//        final String format = "dd MMMM, yyyy";
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
//
//        String formatted = localDate.format(formatter);
//
//        System.out.println(formatted);


        LocalDate localDate = LocalDate.now();
        String format = "dd MMMM, yyyy";

        String formatted = LocalDate.now()
                .format(DateTimeFormatter.ofPattern(format));

        System.out.println(formatted);

        System.out.println(Constants.METHOD_SEPARATOR);

    }


    /**
     * this method will parse string to localDate.
     */
    static void localDateTimeExampleSeven(){

        System.out.println("this method will parse string to localDate.");

        String birthDay = "25 May, 2003";

        LocalDate birthDate = LocalDate.parse(birthDay,DateTimeFormatter.ofPattern("dd MMMM, yyyy"));

        System.out.println(birthDate);

        System.out.println(Constants.METHOD_SEPARATOR);

    }

    /**
     * this method will calculate age from given string date input.
     */
    static void localDateTimeExampleEight(){

        System.out.println("this method will calculate age from given string date input.");

        String birthDay = "25 May, 2003";

        LocalDate birthDate = LocalDate.parse(birthDay,DateTimeFormatter.ofPattern("dd MMMM, yyyy"));

        System.out.println(birthDate);

        calculateAge(birthDate);

        calculateAgeTwo(birthDate);

    }


    /**
     * this method will get localDateTime based on timezone.
     */
    static void localDateTimeExampleNine(){

        System.out.println("this method will get localDateTime based on timezone.");

        String timeZoneId = "America/New_York";
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of(timeZoneId));
        System.out.println("Local Date and Time in " + timeZoneId + ": " + localDateTime);

        System.out.println(Constants.METHOD_SEPARATOR);

    }

    /**
     * this method will print days of the week for given date range
     */
    static void localDateTimeExampleTen(){
        System.out.println("this method will print days of the week for given date range");

        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(7);

        while (!startDate.isAfter(endDate)){
            String dayOfWeek = startDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            System.out.println(startDate+"=>"+dayOfWeek);
            startDate = startDate.plusDays(1);
        }

        System.out.println(Constants.METHOD_SEPARATOR);
    }

    /**
     * this method will check if the given localDateTime is n hours older or not and print the message according to it.
     */
    static void localDateExampleEleven(){
        // Given LocalDateTime object
        LocalDateTime givenDateTime = LocalDateTime.of(2023, 4, 18, 12, 0); // Example: 12:00 PM on April 18, 2023

        int n = 12; // Number of hours

        // Get the current LocalDateTime
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Check if the given LocalDateTime is N hours older than the current time
        boolean isNHoursOlder = givenDateTime.isBefore(currentDateTime.minusHours(n));

        // Print the result
        if (isNHoursOlder) {
            System.out.println("The given LocalDateTime is " + n + " hours older than the current time.");
        } else {
            System.out.println("The given LocalDateTime is NOT " + n + " hours older than the current time.");
        }
    }

    static void localDateExampleTwelve(){

        String inputString = "25 May, 2003 02:00 PM";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM, yyyy hh:mm a");
        try {
            LocalDateTime dateTime = LocalDateTime.parse(inputString, formatter);
            System.out.println(dateTime);
        } catch (DateTimeParseException e) {
            System.err.println("Unable to parse input string as LocalDateTime object: " + e.getMessage());
        }

        System.out.println(Constants.METHOD_SEPARATOR);

    }


    /**
     * this method will take LocalDate as parameter and print age in days, months and years as whole.
     * @param birthdate LocalDate as birthdate.
     */
    private static void calculateAge(LocalDate birthdate){


        LocalDate currentDate = LocalDate.now();

        // with help of period we can get a period object which contains total period in terms of years, months and days.

        Period period = Period.between(birthdate,currentDate);

        System.out.println(period.getYears() +" years " + period.getMonths() +" months "+period.getDays()+" days");
        System.out.println(Constants.METHOD_SEPARATOR);
    }


    /**
     * this method will take LocalDate as parameter and print age in days, months and years individually.
     * @param birthdate LocalDate as birthdate.
     */
    private static void calculateAgeTwo(LocalDate birthdate){

        LocalDate currentDate = LocalDate.now();

        long days = ChronoUnit.DAYS.between(birthdate,currentDate);
        long months = ChronoUnit.MONTHS.between(birthdate,currentDate);
        long years = ChronoUnit.YEARS.between(birthdate,currentDate);

        System.out.println("age in days : "+days +"\n"+"age in months : "+months+"\n"+"age in years : "+years);

        System.out.println(Constants.METHOD_SEPARATOR);

    }



}
