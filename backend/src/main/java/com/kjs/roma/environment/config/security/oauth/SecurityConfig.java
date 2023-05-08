package com.kjs.roma.environment.config.security.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig { //WebSecurityConfigurerAdapter was deprecated
    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService){
        this.customOAuth2UserService = customOAuth2UserService;
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        /*        .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());*/

                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .formLogin().disable()
                .httpBasic().disable()

                //.authorizeRequests()
                //.antMatchers ("/api/**", "/login/**", "/oauth2/**").permitAll ()

                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(
                                new AntPathRequestMatcher("/admin/**/**"),
                                new AntPathRequestMatcher("/api/user/**")).permitAll()
                                .anyRequest().authenticated()
                )
                //.and()
                .oauth2Login()
                .authorizationEndpoint().baseUri("/oauth2/authorize")
                .and()
                .redirectionEndpoint()
                .baseUri("/login/oauth2/code/**")
                .and()
                .userInfoEndpoint().userService(customOAuth2UserService);
        return http.build();
    }
}
