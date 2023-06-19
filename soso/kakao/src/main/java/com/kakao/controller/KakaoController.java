package com.kakao.controller;

import com.common.Common;
import com.common.restapi.RestAPI;
import com.common.utils.AES256;
import com.kakao.dto.KakaoDTO;
import com.kakao.service.itf.KakaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String kakao() throws Exception {
        log.info("kakao");
        return aes256.encrypt(common.com());
    }

    @GetMapping("/kakao1")
    public String kakao1() {
        log.info("kakao1");
        return restAPI.get("http://localhost:8082/api/login");
    }

    @GetMapping("/kakao2")
    public HashMap<String, String> kakao2() {
        log.info("kakao1");
        HashMap<String, String> test = new HashMap<>();
        test.put("aa", "aa");
        return restAPI.post("http://localhost:8082/api/login1", test, HashMap.class);
    }

    @GetMapping("/kakao3")
    public List<HashMap<String, String>> kakao3() {
        log.info("kakao1");
        HashMap<String, String> test = new HashMap<>();
        test.put("aa", "aa");
        List<HashMap<String, String>> list = new ArrayList<>();
        list.add(test);
        list.add(test);
        list.add(test);
        return restAPI.post("http://localhost:8082/api/login2", list, List.class);
    }

    @GetMapping("/kakaoall")
    public List<KakaoDTO> kakaoAll() {
        return kakaoService.testAll();
    }
}
