package org.team.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UploadBundle {
    private String fileName;
    private byte[] content;
    private @Id Long id;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
