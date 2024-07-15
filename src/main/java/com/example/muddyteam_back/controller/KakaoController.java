package com.example.muddyteam_back.controller;

import com.example.muddyteam_back.dto.kakao.KakaoAfterLoginDto;
import com.example.muddyteam_back.dto.kakao.KakaoLoginDto;
import com.example.muddyteam_back.dto.user.UserDto;
import com.example.muddyteam_back.entity.UserEntity;
import com.example.muddyteam_back.jwt.JWTUtil;
import com.example.muddyteam_back.service.KakaoService;
import com.example.muddyteam_back.util.MakeDto;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

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
    private final MakeDto makeDto;

    private final Logger LOGGER = LoggerFactory.getLogger(KakaoController.class);

    @PostMapping("/login")
    public ResponseEntity<UserDto> kakaoRegister(@RequestBody KakaoLoginDto kakaoLoginDto, HttpServletResponse response){

        LOGGER.info("id : {}", kakaoLoginDto.getId());
        LOGGER.info("nickname : {}", kakaoLoginDto.getNickname());
        LOGGER.info("profile_image : {}", kakaoLoginDto.getProfile_image());
        LOGGER.info("thumbnail_image : {}", kakaoLoginDto.getThumbnail_image());

        UserEntity member = kakaoService.kakaoLoginOrRegister(kakaoLoginDto);
        if(member == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        String jwtToken = jwtUtil.createJwt(member.getUsername(), member.getRole(), 60*60*60L);
        response.addHeader("Authorization", jwtToken);
        UserDto userDto = makeDto.makeKALD(member);

        return ResponseEntity.ok(userDto);
    }

}
