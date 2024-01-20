package jaegojaego.back.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String login(){return "login";}

    @GetMapping("/CreateAccount")
    public String createAccount() {return "createAccount";}
}
