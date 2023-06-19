package com.kakao.ra.itf;

import com.kakao.dto.KakaoDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface KakaoRAO {

    public List<KakaoDTO> testAll();

}
