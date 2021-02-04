package org.team.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UploadBundle {
    private String fileName;
    private byte[] content;
    private @Id Long id;
}
