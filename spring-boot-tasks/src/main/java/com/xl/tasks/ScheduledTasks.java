package com.xl.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class ScheduledTasks {

    private static final SimpleDateFormat dfm = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        log.info("The time is now{}",dfm.format(new Date()));
    }

    @Scheduled(cron = "0 35 10 * * ? ")
    public void reportCurrentTime1(){
        log.info("The time is now234{}",dfm.format(new Date()));
    }
}
