package com.example.muddyteam_back.util;

import com.example.muddyteam_back.dto.kakao.KakaoAfterLoginDto;
import com.example.muddyteam_back.dto.user.UserDto;
import com.example.muddyteam_back.entity.UserEntity;
import org.springframework.stereotype.Component;

/**
 * @PackageName : com.example.muddyteam_back.util
 * @FileName : MakeDto
 * @Author : noglass_gongdae
 * @Date : 2024-07-13
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */

@Component
public class MakeDto {

    public UserDto makeKALD(UserEntity userEntity){
        return UserDto.builder()
            .nickname(userEntity.getNickname())
            .profile_image(userEntity.getProfile_image())
            .one_liner(userEntity.getOne_liner())
            .build();
    }

}
