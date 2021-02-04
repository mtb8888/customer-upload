package org.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.team.domain.UploadBundle;

import java.util.List;

@Controller
public class UploadController {
    @PostMapping(value = "/upload")
    public void upload() {
    }

    @GetMapping(value = "/upload/list")
    public List<UploadBundle> list() {
        return null;
    }

    @GetMapping(value = "/upload")
    public UploadBundle getId(@PathVariable int id) {
        return null;
    }
}
