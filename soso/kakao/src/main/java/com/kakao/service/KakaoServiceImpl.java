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
import java.util.stream.Collectors;

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
        // entity to dto
        return raojpa.findAll().stream()
                .map(KakaoDTO::toDTO)
                .collect(Collectors.toList());
    }

    public List<Kakao> testAllJPAA() {
        // entity가져옴
        List<KakaoDTO> kakaoDTOS = raojpa.findAll().stream()
                .map(KakaoDTO::toDTO)
                .collect(Collectors.toList());

        // dto to entity
        return kakaoDTOS.stream()
                .map(Kakao::toEntity)
                .collect(Collectors.toList());
    }

}
