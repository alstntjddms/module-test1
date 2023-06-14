package com.kakao;

import com.common.Common;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KakaoController {
    @GetMapping("kakao")
    public String kakao(){
        Common common = new Common();
        return common.com();
    }
}
