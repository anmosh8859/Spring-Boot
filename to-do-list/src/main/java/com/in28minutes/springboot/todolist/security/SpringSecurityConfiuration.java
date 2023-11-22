package com.in28minutes.springboot.todolist.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiuration {

//    InMemoryUserDetailsManager
//    InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        UserDetails user1 = createNewUser("anand", "password");
        UserDetails user2 = createNewUser("rajat", "password");
        return new InMemoryUserDetailsManager(user1,user2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input->passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                                    .passwordEncoder(passwordEncoder)
                                    .username(username)
                                    .password(password)
                                    .roles("USER","ADMIN")
                                    .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity hs)throws Exception{
        hs.authorizeHttpRequests(
                auth->auth.anyRequest().authenticated());
        hs.formLogin(withDefaults());

        hs.csrf().disable();

        hs.headers().frameOptions().disable();

        return hs.build();
    }
}
