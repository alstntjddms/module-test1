package com.login;

import com.common.Common;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("login")
    public String login(){

        Common common = new Common();

        return common.com();
    }
}
