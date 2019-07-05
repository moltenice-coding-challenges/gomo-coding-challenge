package com.intilled.uvt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class UvtApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(UvtApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UvtApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOGGER.info("Received arguments {}", Arrays.toString(args));
    }
}
