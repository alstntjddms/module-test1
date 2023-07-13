package com.kakao.controller;

import com.common.Common;
import com.common.Log;
import com.common.LogDTO;
import com.common.LogFactory;
import com.common.restapi.AsyncRestAPI;
import com.common.aes.AES256;
import com.common.restapi.RestAPI;
import com.kakao.dto.KakaoDTO;
import com.kakao.service.itf.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
public class KakaoController {
    private Log log;

    @Autowired
    private void setLog(LogFactory logFactory) {
        this.log = logFactory.createLog(KakaoController.class);
    }
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


        System.out.println("KakaoController.kakao");
        System.out.println("log = " + log);
        log.info("kakao", "로그출력");
        // 헤더 전달
//        restAPI.post("http://localhost:8080/api/log/info", new LogDTO("aaa", "aa", "aaa"), LogDTO.class);
        return new ResponseEntity(aes256.encrypt(common.com()), HttpStatus.OK);
    }

    @GetMapping("/kakao1")
    public ResponseEntity kakao1() throws Exception {
        System.out.println("KakaoController.kakao1");
        // 헤더 전달 X
        restAPI.get("http://localhost:8080/api/log/log");
        return new ResponseEntity(aes256.encrypt(common.com()), HttpStatus.OK);
    }

//    @GetMapping("/kakao1")
//    public ResponseEntity kakao1() {
//        log.info("kakao1");
//        return new ResponseEntity(restAPI.get("http://localhost:8082/api/login"), HttpStatus.OK);
//    }

    @PostMapping("/kakao2")
    public ResponseEntity kakao2(@RequestBody HashMap<String, String> test) {
//        log.info("kakao2");
        return new ResponseEntity(restAPI.post("http://localhost:8082/api/login1", test, HashMap.class), HttpStatus.OK);
    }

    @GetMapping("/kakao3")
    public ResponseEntity kakao3() {
//        log.info("kakao1");
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
