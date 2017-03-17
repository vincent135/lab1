package com.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vincentdemilly on 17/03/2017.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String logingPage() {
        return "login";
    }
}
