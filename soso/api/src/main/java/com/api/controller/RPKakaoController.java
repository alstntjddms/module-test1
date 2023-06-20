package com.api.controller;

import com.common.restapi.RestAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RPKakaoController {
    private static final Logger log = LoggerFactory.getLogger(RPKakaoController.class);
    @Autowired
    RestAPI restAPI;

    @GetMapping("/kakao2")
    public ResponseEntity kakao2() {
        log.info("kakao2");
        System.out.println("KakaoController.kakao2");
        HashMap<String, String> test = new HashMap<>();
        test.put("test", "kakao");
        return new ResponseEntity(restAPI.post("http://localhost:8081/api/kakao2", test, HashMap.class), HttpStatus.OK);
    }
}
