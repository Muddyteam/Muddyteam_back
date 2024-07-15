package com.example.muddyteam_back.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @PackageName : com.example.muddyteam_back.entity
 * @FileName : KakaoUserEntity
 * @Author : noglass_gongdae
 * @Date : 2024-07-13
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "muddy_users")
public class UserEntity {

    @Id
    private String username; //provier + provider_id
    private String nickname;
    private String profile_image;
    private String thumbnail_image;
    private String one_liner; //한줄 소개
    private String role; //사용자 권한
    private String provider; //소셜 로그인 제공처
    private Long provider_id; //해당 제공처에서 부여한 id
    private String refresh_token;
}
