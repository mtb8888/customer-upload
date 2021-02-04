package org.team.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class UploadBundle {
    private String fileName;
    private byte[] content;
    private @Id Long id;
}
