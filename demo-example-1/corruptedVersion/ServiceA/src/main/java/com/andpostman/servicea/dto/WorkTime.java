package com.andpostman.servicea.dto;

import java.time.Duration;
import java.time.LocalDateTime;

public class WorkTime {

    private static WorkTime initialiseTime;
    private LocalDateTime dateTime;

    private WorkTime() {
        dateTime = LocalDateTime.now();
    }

    public static synchronized WorkTime getInstance() {
        if (initialiseTime == null) {
            initialiseTime = new WorkTime();
        }
        return initialiseTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public long getTimeDifference() {
        return Duration.between(getDateTime(), LocalDateTime.now()).toSeconds();
    }

}
