package com.kakao.controller;

import com.common.Common;
import com.common.hash.SHA256;
import com.common.log.Log;
import com.common.log.LogFactory;
import com.common.aes.AES256;
import com.common.restapi.RestAPI;
import com.kakao.dto.KakaoDTO;
import com.kakao.service.itf.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.microsoft.aad.msal4j.*;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class KakaoController {
    private final Log log = LogFactory.getInstance().createLog(KakaoController.class);
    @Autowired
    Common common;
    @Autowired
    RestAPI restAPI;
    @Autowired
    AES256 aes256;
    @Autowired
    SHA256 sha256;
    @Autowired
    KakaoService kakaoService;

    @GetMapping("/test")
    public ResponseEntity test() throws Exception {
        try{
            log.info("kakao", "Start");
            System.out.println("getAccessToken = " + getAccessToken());
            return new ResponseEntity(aes256.encrypt(common.com()), HttpStatus.OK);
        }catch (Exception e){
            log.warn("kakao", e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @Scheduled
    public String getAccessToken() throws MalformedURLException, ExecutionException, InterruptedException {
        IClientCredential credential = ClientCredentialFactory.createFromSecret("oLc8Q~qtX-ZX6my.Gd7z3RM3bMhQQ91J5EaPobyu");
        ConfidentialClientApplication application = ConfidentialClientApplication.builder("15203123-534e-4f12-b466-f92c5ba7fdf1", credential)
                .authority("https://login.microsoftonline.com/6369db95-476d-4bbe-8b2b-f6f3926531fb")
                .build();

        ClientCredentialParameters parameters = ClientCredentialParameters.builder(Collections.singleton("https://graph.microsoft.com/.default"))
                .build();

        CompletableFuture<IAuthenticationResult> future = application.acquireToken(parameters);
        IAuthenticationResult tokenResult = future.join();

        IAuthenticationResult result = future.get();

        java.net.http.HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "https://graph.microsoft.com/v1.0/applications/" + "81ec712d-7970-4663-85ad-26798417e992"))
                .header("Authorization", "Bearer " + tokenResult.accessToken())
                .GET()
                .build();

        return tokenResult.accessToken();
    }
    @GetMapping("/kakao")
    public ResponseEntity kakao() throws Exception {
        try{
            log.info("kakao", "Start");
            return new ResponseEntity(aes256.encrypt(common.com()), HttpStatus.OK);
        }catch (Exception e){
            log.warn("kakao", e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
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
