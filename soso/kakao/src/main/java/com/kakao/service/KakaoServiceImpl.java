package com.kakao.service;

import com.kakao.dto.KakaoDTO;
import com.kakao.entity.Kakao;
import com.kakao.ra.itf.KakaoRAO;
import com.kakao.ra.itf.KakaoRAOJPA;
import com.kakao.service.itf.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KakaoServiceImpl implements KakaoService {
    @Autowired
    KakaoRAO rao;

    @Autowired
    KakaoRAOJPA raojpa;

    @Override
    public List<KakaoDTO> testAll() {
        return rao.testAll();
    }

    @Override
    public List<KakaoDTO> testAllJPA() {
        List<KakaoDTO> kakaoDTOS = new ArrayList<>();
        for(Kakao kakao : raojpa.findAll()){
            KakaoDTO kakaoDTO = KakaoDTO.builder()
                    .id(kakao.getId())
                    .kakaoId(kakao.getKakaoId())
                    .kakaoAccessToken(kakao.getKakaoAccessToken())
                    .kakaoRefreshToken(kakao.getKakaoRefreshToken())
                    .kakaoEmail(kakao.getKakaoEmail())
                    .kakaoNickName(kakao.getKakaoNickName())
                    .kakaoGender(kakao.getKakaoGender())
                    .kakaoBirthday(kakao.getKakaoBirthday())
                    .kakaoRegisterDate(kakao.getKakaoRegisterDate())
                    .kakaoLoginDate(kakao.getKakaoLoginDate())
                    .kakaoMsgYn(kakao.isKakaoMsgYn())
                    .kakaoScopeCheck(kakao.isKakaoScopeCheck())
                    .build();
            kakaoDTOS.add(kakaoDTO);
        }
        return kakaoDTOS;
    }

}
