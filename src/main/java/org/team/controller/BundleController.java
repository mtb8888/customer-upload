package org.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.team.domain.Bundle;
import org.team.repository.BundleRepository;
import org.team.service.BundleService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class BundleController {

    private BundleService bundleService;

    private BundleRepository bundleRepository;

    @Autowired
    private BundleController(BundleService bundleService, BundleRepository bundleRepository) {
        this.bundleService = bundleService;
        this.bundleRepository = bundleRepository;
    }

    @PostMapping(value = "/bundle")
    public void upload(@RequestBody MultipartFile file) throws Exception {
        //TODO check this is correct for the upload form later
        bundleService.validateUploadAndPersist(createUpload(file));
    }

    private Bundle createUpload(MultipartFile file) throws IOException {
        Bundle bundle = new Bundle();
        bundle.setContent(file.getBytes());
        bundle.setFileName(file.getOriginalFilename());
        return bundle;
    }

    @GetMapping(value = "/bundle/list")
    @ResponseBody
    public List<Bundle> list() {
        return bundleRepository.findAll();
    }

    @GetMapping(value = "/bundle/{id}/file-download")
    @ResponseBody
    public void getId(@PathVariable Long id, HttpServletResponse response) throws Exception {
        Bundle bundle = bundleRepository.findById(id).orElseThrow(Exception::new);
        response.getOutputStream().write(bundle.getContent());
        response.getOutputStream().flush();
    }

    //Yuck, but maybe if all in one?

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/cs")
    public String cs() {
        return "cs";
    }

    @RequestMapping(value = "/upload-error")
    public String error() {
        return "error";
    }
}
