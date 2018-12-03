package com.oazofeifa.tcudrake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;

@SpringBootApplication
public class TcuDrakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcuDrakeApplication.class, args);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public StringKeyGenerator generateSecretKey() {
        return KeyGenerators.string();
    }
}
