package com.example.muddyteam_back.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @PackageName : com.example.muddyteam_back.dto.user
 * @FileName : UserDto
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
public class UserDto {

    private String username;
    private String nickname;
    private String profileImage;
    private String oneLiner;
    private String role;

}
