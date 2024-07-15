package com.example.muddyteam_back.service;

import com.example.muddyteam_back.dto.kakao.KakaoLoginDto;
import com.example.muddyteam_back.entity.UserEntity;

/**
 * @PackageName : com.example.muddyteam_back.service.impl
 * @FileName : KakaoService
 * @Author : noglass_gongdae
 * @Date : 2024-07-13
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */
public interface KakaoService {

    public UserEntity kakaoLoginOrRegister(KakaoLoginDto kakaoLoginDto);

}
