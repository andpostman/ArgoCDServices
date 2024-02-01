package com.andpostman.servicea.component;

import com.andpostman.servicea.dto.WorkTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class TimeInitialiseStartup {

    @PostConstruct
    private void initialiseTime() {
        WorkTime timeInitialise = WorkTime.getInstance();
        log.info("Start time: " + timeInitialise.getDateTime());
    }
}
