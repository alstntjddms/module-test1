package com.kakao.ra.itf;

import com.kakao.entity.Kakao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoRAOJPA extends JpaRepository<Kakao, Integer> {
}
