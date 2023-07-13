package com.log.controller;

import com.common.Common;
import com.common.LogDTO;
import com.common.restapi.RestAPI;
import com.common.aes.AES256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class LogController {
    private final static Logger log = LoggerFactory.getLogger(LogController.class);
    @Autowired
    Common common;
    @Autowired
    RestAPI restAPI;
    @Autowired
    AES256 aes256;

    @PostMapping("/info")
    public ResponseEntity info(@RequestBody LogDTO logDTO) throws Exception {
        System.out.println("LogController.kakao");
        log.info(logDTO.getClassName() + logDTO.getMethodName() + logDTO.getLog());

        return new ResponseEntity(aes256.encrypt(common.com()), HttpStatus.OK);
    }
    @GetMapping("/warn")
    public ResponseEntity warn() throws Exception {
        System.out.println("LogController.kakao");
        log.info("kakao");
        return new ResponseEntity(aes256.encrypt(common.com()), HttpStatus.OK);
    }

//    @GetMapping("/kakao1")
//    public ResponseEntity kakao1() {
//        log.info("kakao1");
//        return new ResponseEntity(restAPI.get("http://localhost:8082/api/login"), HttpStatus.OK);
//    }
}
