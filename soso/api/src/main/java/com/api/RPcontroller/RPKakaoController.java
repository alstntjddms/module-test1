package com.api.RPcontroller;

import com.common.restapi.AsyncRestAPI;
import com.common.restapi.RestAPI;
import com.common.url.URL;
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
    @Autowired
    AsyncRestAPI asyncRestAPI;

    @GetMapping("/kakao2")
    public ResponseEntity kakao2() {
        log.info("kakao2");
        System.out.println("KakaoController.kakao2");
        HashMap<String, String> test = new HashMap<>();
        test.put("test", "kakao");
        System.out.println(URL.KAKAO_SERVER);
        return new ResponseEntity(asyncRestAPI.post(URL.KAKAO_SERVER + "2", test, HashMap.class).block(), HttpStatus.OK);
    }

}
