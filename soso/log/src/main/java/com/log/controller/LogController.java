package com.log.controller;

import com.common.Common;
import com.common.LogDTO;
import com.common.restapi.RestAPI;
import com.common.aes.AES256;
import com.log.service.itf.LogService;
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
    LogService logService;
    @PostMapping("/info")
    public ResponseEntity info(@RequestBody LogDTO logDTO) {
        try{
            System.out.println("LogController.info");
            return new ResponseEntity(logService.info(logDTO), HttpStatus.OK);
        }catch (Exception e){
            log.warn(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/warn")
    public ResponseEntity warn(@RequestBody LogDTO logDTO) {
        try{
            return new ResponseEntity(logService.warn(logDTO), HttpStatus.OK);
        }catch (Exception e){
            log.warn(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/debug")
    public ResponseEntity debug(@RequestBody LogDTO logDTO) {
        try{
            return new ResponseEntity(logService.debug(logDTO), HttpStatus.OK);
        }catch (Exception e){
            log.warn(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
