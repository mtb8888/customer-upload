package org.team.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.team.domain.Bundle;
import org.team.repository.BundleRepository;

import java.time.LocalDateTime;

@Service
public class BundleService {

    private CustomLogger logger;

    private BundleRepository bundleRepository;

    @Autowired
    private BundleService(BundleRepository bundleRepository, CustomLogger logger) {
        this.bundleRepository = bundleRepository;
        this.logger = logger;
    }

    public void validateUploadAndPersist(Bundle bundle) throws Exception {
        if (validateBinary(bundle.getContent())) {
            logger.log(this.getClass().getSimpleName(),
                    "validateUploadAndPersist",
                    "info",
                    "Validated " + bundle.getFileName(),
                    LocalDateTime.now());
            bundleRepository.save(bundle);
        } else {
            logger.log(this.getClass().getSimpleName(),
                    "validateUploadAndPersist",
                    "error",
                    "File not valid, " + bundle.getFileName(),
                    LocalDateTime.now());
            throw new Exception("Failed to persist submitted file");
        }
    }

    private boolean validateBinary(byte[] content) {
        //mostly just inventing this to pretend something servicy happens.
        return true;
    }
}
