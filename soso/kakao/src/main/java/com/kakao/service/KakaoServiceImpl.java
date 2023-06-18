package com.kakao.service;

import com.kakao.dto.KakaoDTO;
import com.kakao.ra.itf.KakaoRAO;
import com.kakao.service.itf.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KakaoServiceImpl implements KakaoService {
    @Autowired
    KakaoRAO rao;

    @Override
    public List<KakaoDTO> testAll() {
        return rao.testAll();
    }
}
