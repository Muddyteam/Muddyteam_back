package com.example.muddyteam_back.mapper;

import com.example.muddyteam_back.dto.request.KakaoLoginDto;
import com.example.muddyteam_back.dto.response.UserDto;
import com.example.muddyteam_back.entity.UserEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

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

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "username", constant = "")
    @Mapping(source = "nickname", target = "nickname")
    @Mapping(source = "profileImage", target = "profileImage")
    @Mapping(source = "thumbnailImage", target = "thumbnailImage")
    @Mapping(target = "role", constant = "ROLE_USER")
    @Mapping(target = "provider", constant = "kakao")
    @Mapping(target = "oneLiner", constant = "")
    @Mapping(source = "id", target = "providerId")
    @Mapping(target = "accessToken", ignore = true)
    @Mapping(target = "refreshToken", ignore = true)
    @Mapping(target = "version", ignore = true)
    UserEntity kakaoLoginDtoToUserEntity(KakaoLoginDto kakaoLoginDto);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "nickname", target = "nickname")
    @Mapping(source = "profileImage", target = "profileImage")
    @Mapping(source = "oneLiner", target = "oneLiner")
    @Mapping(source = "role", target = "role")
    UserDto UserEntityToUserDto(UserEntity userEntity);

    @AfterMapping
    default void setCustomUsername(@MappingTarget UserEntity userEntity, KakaoLoginDto kakaoLoginDto) {
        userEntity.setUsername("kakao_" + kakaoLoginDto.getId());
    }
}
