package com.petvax.petvaxServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ServletComponentScan(basePackages = {"com.petvax.petvaxServices.config", "com.petvax.petvaxServices.servlet"})
@SpringBootApplication
public class VaccinationsApplication {

    public static void main(final String[] args) {
        SpringApplication.run(VaccinationsApplication.class, args);
    }

}
