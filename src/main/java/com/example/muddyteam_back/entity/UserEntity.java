package com.example.muddyteam_back.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
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
public class UserEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false)
    private String username; //provier + provider_id

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "thumbnail_image")
    private String thumbnailImage;

    @Column(name = "one_liner")
    private String oneLiner;//한줄 소개

    @Column(name = "role", nullable = false)
    private String role; //사용자 권한

    @Column(name = "provider")
    private String provider; //소셜 로그인 제공처

    @Column(name = "provider_id")
    private Long providerId; //해당 제공처에서 부여한 id

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Version
    private int version;
}
