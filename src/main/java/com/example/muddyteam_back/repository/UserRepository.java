package com.example.muddyteam_back.repository;

import com.example.muddyteam_back.entity.UserEntity;
import java.util.Optional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @PackageName : com.example.muddyteam_back.repository
 * @FileName : UserRepository
 * @Author : noglass_gongdae
 * @Date : 2024-07-13
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByUsername(@NonNull String username);

}
