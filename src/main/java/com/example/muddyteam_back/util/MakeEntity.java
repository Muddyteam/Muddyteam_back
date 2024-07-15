package com.example.muddyteam_back.util;

import com.example.muddyteam_back.dto.kakao.KakaoLoginDto;
import com.example.muddyteam_back.entity.UserEntity;
import org.springframework.stereotype.Component;

/**
 * @PackageName : com.example.muddyteam_back.util
 * @FileName : MakeEntity
 * @Author : noglass_gongdae
 * @Date : 2024-07-13
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */

@Component
public class MakeEntity {

    public UserEntity makeUserEntity(KakaoLoginDto kakaoLoginDto){

        String username = "kakao_" + kakaoLoginDto.getId();
        String nickname = kakaoLoginDto.getNickname();
        String profile_image = kakaoLoginDto.getProfile_image();
        String thumbnail_image = kakaoLoginDto.getThumbnail_image();
        String role = "ROLE_USER";
        String provider = "kakao";
        String one_liner = "한줄로 자신을 소개해 보세요!";
        Long provider_id = kakaoLoginDto.getId();

        return UserEntity.builder()
            .username(username)
            .nickname(nickname)
            .profile_image(profile_image)
            .thumbnail_image(thumbnail_image)
            .role(role)
            .provider(provider)
            .provider_id(provider_id)
            .one_liner(one_liner)
            .build();
    }

}
