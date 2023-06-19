package com.login;

import com.common.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@ComponentScan(value={"com.common", "com.login"})
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public ResponseEntity login(){
        System.out.println("LoginController.login");
        log.info("login");
        Common common = new Common();
        return new ResponseEntity(common.com(), HttpStatus.OK);
    }

    @PostMapping("/login1")
    public ResponseEntity login(@RequestBody HashMap<String, String> test){
        System.out.println("LoginController.login1");
        log.info("login1");
        return new ResponseEntity(test, HttpStatus.OK);
    }

    @PostMapping("/login2")
    public ResponseEntity login(@RequestBody List<HashMap<String, String>> test){
        System.out.println("LoginController.login2");
        log.info("login2");
        return new ResponseEntity(test, HttpStatus.OK);
    }
}
