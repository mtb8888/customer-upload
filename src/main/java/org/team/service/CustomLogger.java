package org.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.team.domain.LogEvent;
import org.team.repository.LogEventRepository;

import java.time.LocalDateTime;

@Component
public class CustomLogger {

    private LogEventRepository logEventRepository;

    @Autowired
    private CustomLogger(LogEventRepository logEventRepository) {
        this.logEventRepository = logEventRepository;
    }

    public void logEvent(LogEvent logEvent) {
        logEventRepository.save(logEvent);
    }

    public void log(String className, String methodName, String eventLevel,
                        String eventDescription, LocalDateTime eventTime) {
        LogEvent logEvent = new LogEvent();
        logEvent.setClassName(className);
        logEvent.setMethodName(methodName);
        logEvent.setEventLevel(eventLevel);
        logEvent.setEventDescription(eventDescription);
        logEvent.setEventTime(eventTime);
        this.logEvent(logEvent);
    }
}
