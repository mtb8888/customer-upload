package org.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    //Hook into React via index.html
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
