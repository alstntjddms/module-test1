package com.kakao.ra.itf;

import com.kakao.dto.KakaoDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface KakaoRAO {

    final String testAll = "SELECT * FROM soso.kakao";

    @Select(testAll)
    public List<KakaoDTO> testAll();

}
