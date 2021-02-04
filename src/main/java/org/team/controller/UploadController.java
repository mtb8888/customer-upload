package org.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.team.domain.UploadBundle;
import org.team.repository.UploadBundleRepository;
import org.team.service.UploadService;

import java.util.List;

@Controller
public class UploadController {

    private UploadService uploadService;

    private UploadBundleRepository uploadBundleRepository;

    @Autowired
    private UploadController(UploadService uploadService, UploadBundleRepository uploadBundleRepository) {
        this.uploadService = uploadService;
        this.uploadBundleRepository = uploadBundleRepository;
    }

    @PostMapping(value = "/upload")
    public void upload(@RequestBody UploadBundle uploadBundle ) throws Exception {
        uploadService.validateUploadAndPersist(uploadBundle);
    }

    @GetMapping(value = "/upload/list")
    public List<UploadBundle> list() {
        return uploadBundleRepository.findAll();
    }

    @GetMapping(value = "/upload")
    public UploadBundle getId(@PathVariable Long id) throws Exception {
        return uploadBundleRepository.findById(id).orElseThrow(Exception::new);
    }
}
