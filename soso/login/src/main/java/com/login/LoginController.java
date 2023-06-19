package com.login;

import com.common.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@ComponentScan(value={"com.common", "com.login"})
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String login(){
        System.out.println("LoginController.login");
        log.info("login");
        Common common = new Common();
        return common.com();
    }

    @PostMapping("/login1")
    public HashMap<String, String> login(@RequestBody HashMap<String, String> test){
        System.out.println("LoginController.login1");
        log.info("login1");
        return test;
    }

    @PostMapping("/login2")
    public List<HashMap<String, String>> login(@RequestBody List<HashMap<String, String>> test){
        System.out.println("LoginController.login2");
        log.info("login2");
        return test;
    }
}
