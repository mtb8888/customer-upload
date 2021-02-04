package org.team.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
public class LogEvent {
    private String className;
    private String methodName;
    private String eventLevel; //maybe enum?
    private String eventDescription;
    private LocalDateTime eventTime;
    private @Id Long id;
}
