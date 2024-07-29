package com.example.muddyteam_back.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @PackageName : com.example.muddyteam_back.dto.kakao
 * @FileName : KakaoLoginDto
 * @Author : noglass_gongdae
 * @Date : 2024-07-13
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class KakaoLoginDto {

    private Long id;
    private String nickname;
    private String profileImage;
    private String thumbnailImage;

}
