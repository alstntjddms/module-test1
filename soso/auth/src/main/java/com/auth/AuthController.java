package com.auth;

import com.common.hash.SHA256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

@RestController
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    SHA256 sha256;
    @GetMapping("/login")
    public ResponseEntity login() throws Exception {

        // 회원가입시 비밀번호 hash함수 적용 예제
        // DB에 salt, hashPassWord 저장
        String passWord = "password";
        String salt = sha256.generateSalt();
        String hashPassWord = sha256.hash(passWord, salt);


        // 로그인시 비밀번호 검증
        // 아이디로 hashPassWord, salt 가져옴
        sha256.validate("password", salt, hashPassWord);

        return new ResponseEntity(sha256.validate("password", salt, hashPassWord), HttpStatus.OK);
    }

    @PostMapping("/login1")
    public ResponseEntity login(@RequestBody HashMap<String, String> test){
        System.out.println("LoginController.login1");
        log.info("login1");
        return new ResponseEntity(test, HttpStatus.OK);
    }

    @PostMapping("/login2")
    public ResponseEntity login(@RequestBody List<HashMap<String, String>> test){
        System.out.println("LoginController.login2");
        log.info("login2");
        return new ResponseEntity(test, HttpStatus.OK);
    }
}
