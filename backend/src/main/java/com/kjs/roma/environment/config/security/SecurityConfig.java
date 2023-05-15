package com.kjs.roma.environment.config.security;

import com.kjs.roma.environment.config.security.oauth.CustomOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
//@EnableWebSecurity
public class SecurityConfig { //WebSecurityConfigurerAdapter was deprecated
    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService){
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()   // * csrf : 사이트간 위조 요청
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .formLogin().disable()
//                .httpBasic().disable()
//                .authorizeHttpRequests((authz) -> authz
//                        .requestMatchers(
//                                new AntPathRequestMatcher("/admin/**/**"),
//                                new AntPathRequestMatcher("/api/user/**")).permitAll()
//                                .anyRequest().authenticated()
//                )
//                .oauth2Login()
//                .authorizationEndpoint().baseUri("/oauth2/authorize")
//                .and()
//                .redirectionEndpoint()
//                .baseUri("/login/oauth2/code/**")
//                .and()
//                .userInfoEndpoint().userService(customOAuth2UserService);
//        return http.build();
//    }
}
