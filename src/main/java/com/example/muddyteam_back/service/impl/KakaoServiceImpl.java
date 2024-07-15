package com.example.muddyteam_back.service.impl;

import com.example.muddyteam_back.dto.kakao.KakaoLoginDto;
import com.example.muddyteam_back.entity.UserEntity;
import com.example.muddyteam_back.repository.UserRepository;
import com.example.muddyteam_back.service.KakaoService;
import com.example.muddyteam_back.util.MakeDto;
import com.example.muddyteam_back.util.MakeEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @PackageName : com.example.muddyteam_back.service.impl
 * @FileName : KakaoServiceImpl
 * @Author : noglass_gongdae
 * @Date : 2024-07-13
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */

@Service
@RequiredArgsConstructor
@Transactional
public class KakaoServiceImpl implements KakaoService{

    private final MakeEntity makeEntity;
    private final MakeDto makeDto;
    private final UserRepository userRepository;

    @Override
    public UserEntity kakaoLoginOrRegister(KakaoLoginDto kakaoLoginDto) {

        UserEntity userEntity = makeEntity.makeUserEntity(kakaoLoginDto);
        return saveOrReturnUser(userEntity);
    }

    public UserEntity saveOrReturnUser(UserEntity user){
        Optional<UserEntity> findUser = userRepository.findByUsername(user.getUsername());
        return findUser.orElse(userRepository.save(user));
    }
}
