package com.example.muddyteam_back.controller;

import com.example.muddyteam_back.dto.request.KakaoLoginDto;
import com.example.muddyteam_back.dto.response.UserDto;
import com.example.muddyteam_back.jwt.JWTUtil;
import com.example.muddyteam_back.service.KakaoService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @PackageName : com.example.muddyteam_back.controller
 * @FileName : KakaoController
 * @Author : noglass_gongdae
 * @Date : 2024-07-13
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */

@RestController
@RequestMapping("/kakao")
@RequiredArgsConstructor
public class KakaoController {

    private final JWTUtil jwtUtil;
    private final KakaoService kakaoService;

    private final Logger LOGGER = LoggerFactory.getLogger(KakaoController.class);

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<UserDto> kakaoRegister(@RequestBody KakaoLoginDto kakaoLoginDto, HttpServletResponse response){

        LOGGER.info("id : {}", kakaoLoginDto.getId());
        LOGGER.info("nickname : {}", kakaoLoginDto.getNickname());
        LOGGER.info("profile_image : {}", kakaoLoginDto.getProfileImage());
        LOGGER.info("thumbnail_image : {}", kakaoLoginDto.getThumbnailImage());

        UserDto userDto = kakaoService.kakaoLoginOrRegister(kakaoLoginDto);
        if(userDto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        String jwtToken = jwtUtil.createJwt(userDto.getUsername(), userDto.getRole(), 60*60*60L);
        response.addHeader("Authorization", jwtToken);

        return ResponseEntity.ok(userDto);
    }

}
