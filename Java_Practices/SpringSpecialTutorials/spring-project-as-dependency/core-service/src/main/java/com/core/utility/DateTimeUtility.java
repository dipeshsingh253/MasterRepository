package com.core.utility;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class DateTimeUtility {

    public LocalDateTime provideLocalDateTimeOfPatter(String dateTime,String pattern){
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(pattern));
    }


    public void printTodayYesterdayTomorrowDate(){
        LocalDate today = LocalDate.now();

        log.info("Today's Date : {}",today);
        log.info("Yesterday's Date : {}",today.minusDays(1));
        log.info("Tomorrow's Date : {}",today.plusDays(2));

    }

    public void printNthNextDay(LocalDate date,long n){
        log.info("Nth next day from date : {} is {}",date,date.plusDays(n));
    }

    public void printNthPreviousDay(LocalDate date,long n){
        log.info("Nth previous day from date : {} is {}",date,date.minusDays(n));
    }


}
