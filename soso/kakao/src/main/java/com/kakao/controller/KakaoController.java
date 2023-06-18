package com.kakao.controller;

import com.common.Common;
import com.common.utils.AES256;
import com.kakao.dto.KakaoDTO;
import com.kakao.service.itf.KakaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class KakaoController {
    private static final Logger log = LoggerFactory.getLogger(KakaoController.class);
    @Autowired
    Common common;
    @Autowired
    AES256 aes256;
    @Autowired
    KakaoService kakaoService;
    @GetMapping("/kakao")
    public String kakao() throws Exception {
        log.info("kakao");
        return aes256.encrypt(common.com());
    }

    @GetMapping("/kakaoall")
    public List<KakaoDTO> kakaoAll() throws Exception {
        return kakaoService.testAll();
    }
}
