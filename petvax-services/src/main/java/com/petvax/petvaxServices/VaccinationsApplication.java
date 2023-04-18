package com.petvax.petvaxServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@ServletComponentScan
@SpringBootApplication
public class VaccinationsApplication {

    public static void main(final String[] args) {
        SpringApplication.run(VaccinationsApplication.class, args);
    }

}
