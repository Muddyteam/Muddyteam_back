package com.example.muddyteam_back.config;

import com.example.muddyteam_back.jwt.JWTFilter;
import com.example.muddyteam_back.jwt.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

/**
 * @PackageName : com.example.muddyteam_back.config
 * @FileName : SecurityConfig
 * @Author : noglass_gongdae
 * @Date : 2024-07-13
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Value("${cors.client.url}")
    private String client_URL;

    private final JWTUtil jwtUtil;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .addFilterBefore(new JWTFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
        //csrf disable
        http
            .csrf((auth) -> auth.disable());
        http
            .headers(headers -> headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));

        //Form 로그인 방식 disable
        http
            .formLogin((auth) -> auth.disable());

        //http basic 인증 방식 disable
        http
            .httpBasic((auth) -> auth.disable());

        //경로별 인가 작업
        http
            .authorizeHttpRequests((auth) -> auth
                .requestMatchers("/muddy/**", "/v3/**").permitAll() //swagger api
                .requestMatchers("/kakao/login/**").permitAll()
                .anyRequest().authenticated());

        http
            .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
                // filterChain이 요청을 가로채고 해당 요청에 대해 보안 설정을 진행
                // 전역 Cors 설정보다 먼저 적용됨
                @Override
                public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {

                    CorsConfiguration configuration = new CorsConfiguration();

                    configuration.setAllowedOrigins(Collections.singletonList(client_URL));
                    configuration.setAllowedMethods(Collections.singletonList("*"));
                    configuration.setAllowCredentials(true); //서버가 클라이언트에게 인증된 사용자 정보를 전달할 수 있는지 여부를 결정
                    configuration.setAllowedHeaders(Collections.singletonList("*")); // 모든 헤더 허용
                    configuration.setMaxAge(3600L); //캐시 기간 설정
                    //서버에서 클라이언트로 반환될 때 노출되는 헤더를 설정하는 부분
                    // configuration.setExposedHeaders(Collections.singletonList("Set-Cookie")); //쿠키를 설정할 때 사용
                    configuration.setExposedHeaders(Collections.singletonList("Authorization")); //인증된 요청을 할 때 사용
                    configuration.setExposedHeaders(Collections.singletonList("RefreshToken"));
                    //서버로부터 반환되는 응답에 있는 헤더들을 접근할 수 있게됨.
                    return configuration;
                }
            }));

        //세션 설정 - jwt 방식에선 사용하지 않음
        http
            .sessionManagement((session) -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        //H2 console 사용을 위함
        http
            .csrf(csrf -> csrf.disable());
        http
            .headers(headers -> headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));
        return http.build();
    }

}
