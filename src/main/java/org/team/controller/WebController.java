package org.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
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
