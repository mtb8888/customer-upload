package org.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.UploadBundle;
import org.team.repository.UploadBundleRepository;

import java.time.LocalDateTime;

@Service
public class UploadService {

    private CustomLogger logger;

    private UploadBundleRepository uploadBundleRepository;

    @Autowired
    private UploadService(UploadBundleRepository uploadBundleRepository, CustomLogger logger) {
        this.uploadBundleRepository = uploadBundleRepository;
        this.logger = logger;
    }

    public void validateUploadAndPersist(UploadBundle uploadBundle) throws Exception {
        if (validateBinary(uploadBundle.getContent())) {
            logger.log(this.getClass().getSimpleName(),
                    "validateUploadAndPersist",
                    "info",
                    "Validated " + uploadBundle.getFileName(),
                    LocalDateTime.now());
            uploadBundleRepository.save(uploadBundle);
        } else {
            logger.log(this.getClass().getSimpleName(),
                    "validateUploadAndPersist",
                    "error",
                    "File not valid, " + uploadBundle.getFileName(),
                    LocalDateTime.now());
            throw new Exception("Failed to persist submitted file");
        }
    }

    private boolean validateBinary(byte[] content) {
        //mostly just inventing this to pretend something servicy happens.
        return true;
    }
}
