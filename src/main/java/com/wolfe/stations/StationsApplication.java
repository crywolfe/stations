package com.wolfe.stations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StationsApplication.class, args);
    }

}
