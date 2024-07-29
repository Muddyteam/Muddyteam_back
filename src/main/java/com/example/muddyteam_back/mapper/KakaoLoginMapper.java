package com.example.muddyteam_back.mapper;

import com.example.muddyteam_back.dto.request.KakaoLoginDto;
import com.example.muddyteam_back.dto.response.UserDto;
import com.example.muddyteam_back.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @PackageName : com.example.muddyteam_back.mapper
 * @FileName : kakaoLoginOrRegisterMapper
 * @Author : noglass_gongdae
 * @Date : 2024-07-28
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */

@Mapper(componentModel = "spring")
public interface KakaoLoginMapper {

    @Mapping(target = "username", expression = "java('kakao_' + kakaoLoginDto.getId())")
    @Mapping(source = "nickname", target = "nickname")
    @Mapping(source = "profileImage", target = "profileImage")
    @Mapping(source = "thumbnailImage", target = "thumbnailImage")
    @Mapping(target = "role", constant = "ROLE_USER")
    @Mapping(target = "provider", constant = "kakao")
    @Mapping(target = "oneLiner", constant = "")
    @Mapping(source = "id", target = "providerId")
    UserEntity kakaoLoginDtoToUserEntity(KakaoLoginDto kakaoLoginDto);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "nickname", target = "nickname")
    @Mapping(source = "profileImage", target = "profileImage")
    @Mapping(source = "oneLiner", target = "oneLiner")
    @Mapping(source = "role", target = "role")
    UserDto UserEntityToUserDto(UserEntity userEntity);
}
