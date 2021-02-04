package org.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    //TODO now will have to consider serving more pages for list/submit
}
