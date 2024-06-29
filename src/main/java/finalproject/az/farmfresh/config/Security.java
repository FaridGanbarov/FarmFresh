package finalproject.az.farmfresh.config;

import finalproject.az.farmfresh.config.auth.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {
    @Autowired
    private CustomUserDetailService userDetailService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(x->x.disable())
                .authorizeHttpRequests(request-> request
                        .requestMatchers("/admin").hasAnyAuthority("Admin", "Moderator")
                        .requestMatchers("/admin/**").hasAuthority("Admin")
                        .anyRequest().permitAll()

                )
                .formLogin(form-> form
                        .defaultSuccessUrl("/admin")
                        .loginPage("/login")
                        .failureUrl("/login")


                )
                .logout(logout->
                        logout.logoutSuccessUrl("/login")
                )
                .exceptionHandling(e->e
                        .accessDeniedPage("/login")

                );
        return http.build();
    }
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder());
    }
}