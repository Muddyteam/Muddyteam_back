package com.example.muddyteam_back.service;

import com.example.muddyteam_back.dto.request.KakaoLoginDto;
import com.example.muddyteam_back.dto.response.UserDto;
import com.example.muddyteam_back.entity.UserEntity;
import com.example.muddyteam_back.jwt.JWTUtil;
import com.example.muddyteam_back.mapper.KakaoLoginMapper;
import com.example.muddyteam_back.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PackageName : com.example.muddyteam_back.service
 * @FileName : KakaoService
 * @Author : noglass_gongdae
 * @Date : 2024-07-28
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */
@Service
@RequiredArgsConstructor
@Transactional
public class KakaoService {

    private final UserRepository userRepository;
    private final KakaoLoginMapper kakaoLoginMapper;

    public UserDto kakaoLoginOrRegister(KakaoLoginDto kakaoLoginDto) {
        UserEntity userEntity = kakaoLoginMapper.kakaoLoginDtoToUserEntity(kakaoLoginDto);
        UserEntity member = saveOrReturnUser(userEntity);

        return kakaoLoginMapper.UserEntityToUserDto(member);
    }

    public void createAccessTokenAndRefreshToken(String username, String role){

    }

    public UserEntity saveOrReturnUser(UserEntity user){
        Optional<UserEntity> findUser = userRepository.findByUsername(user.getUsername());
        return findUser.orElse(userRepository.save(user));
    }
}

