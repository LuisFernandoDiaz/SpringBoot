package pe.edu.cibertec.backoffice_d.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                //elegir ruta protegida y quien puede acceder a ellas
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/manage/login").permitAll()//establece ruta con acceso pulico
                        .requestMatchers("/manage/start").hasAnyRole("ADMIN","OPERATOR")//acceso es para admin y para operator
                        .anyRequest().authenticated()//el resto debe autenticarse
                )

                .exceptionHandling(exp -> exp
                        .accessDeniedHandler((req, resp, e)->{
                            resp.sendRedirect("/manage/restricted");
                        })
                )

                .formLogin(form -> form
                .loginPage("/manage/login")
                                .defaultSuccessUrl("manage/start", false)
                                .permitAll()
                )

                .logout(logout -> logout
                        .logoutUrl("/manage/logout")
                        .logoutSuccessUrl("/manage/login?logout")
                        .permitAll()
                );

        return http.build();

    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public UserDetailsService userDetailsService(){
        return username -> User.builder()
                .username("admin")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN")
                .build();
    }


}
