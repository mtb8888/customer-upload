package org.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.team.domain.UploadBundle;
import org.team.repository.UploadBundleRepository;
import org.team.service.UploadService;

import java.io.IOException;
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
    public void upload(@RequestBody MultipartFile file) throws Exception {
        //TODO check this is correct for the upload form later
        uploadService.validateUploadAndPersist(createUpload(file));
    }

    private UploadBundle createUpload(MultipartFile file) throws IOException {
        UploadBundle uploadBundle = new UploadBundle();
        uploadBundle.setContent(file.getBytes());
        uploadBundle.setFileName(file.getOriginalFilename());
        return uploadBundle;
    }

    @GetMapping(value = "/upload/list")
    @ResponseBody
    public List<UploadBundle> list() {
        return uploadBundleRepository.findAll();
    }

    @GetMapping(value = "/upload/{id}")
    @ResponseBody
    public UploadBundle getId(@PathVariable Long id) throws Exception {
        return uploadBundleRepository.findById(id).orElseThrow(Exception::new);
    }
}
