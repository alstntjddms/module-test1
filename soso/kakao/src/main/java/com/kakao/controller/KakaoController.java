package com.kakao.controller;

import com.common.Common;
import com.common.restapi.RestAPI;
import com.common.aes.AES256;
import com.kakao.dto.KakaoDTO;
import com.kakao.service.itf.KakaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
public class KakaoController {
    private static final Logger log = LoggerFactory.getLogger(KakaoController.class);
    @Autowired
    Common common;
    @Autowired
    RestAPI restAPI;
    @Autowired
    AES256 aes256;
    @Autowired
    KakaoService kakaoService;

    @GetMapping("/kakao")
    public ResponseEntity kakao() throws Exception {
        log.info("kakao");
        return new ResponseEntity(aes256.encrypt(common.com()), HttpStatus.OK);
    }

    @GetMapping("/kakao1")
    public ResponseEntity kakao1() {
        log.info("kakao1");
        return new ResponseEntity(restAPI.get("http://localhost:8082/api/login"), HttpStatus.OK);
    }

    @PostMapping("/kakao2")
    public ResponseEntity kakao2(@RequestBody HashMap<String, String> test) {
        log.info("kakao2");
        return new ResponseEntity(restAPI.post("http://localhost:8082/api/login1", test, HashMap.class), HttpStatus.OK);
    }

    @GetMapping("/kakao3")
    public ResponseEntity kakao3() {
        log.info("kakao1");
        HashMap<String, String> test = new HashMap<>();
        test.put("aa", "aa");
        List<HashMap<String, String>> list = new ArrayList<>();
        list.add(test);
        list.add(test);
        list.add(test);
        return new ResponseEntity(restAPI.post("http://localhost:8082/api/login2", list, List.class), HttpStatus.OK);
    }

    @GetMapping("/kakaoall")
    public List<KakaoDTO> kakaoAll() {
        return kakaoService.testAll();
    }

    @GetMapping("/kakaoalljpa")
    public List<KakaoDTO> kakaoAllJPA() {
        return kakaoService.testAllJPA();
    }
}
