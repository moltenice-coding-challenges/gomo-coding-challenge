package com.intilled.uvt;

import com.intilled.uvt.calculator.UvtCalculator;
import com.intilled.uvt.model.Fragment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class UvtApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(UvtApplication.class);
    private final UvtCalculator calculator;

    @Autowired
    public UvtApplication(UvtCalculator calculator) {
        this.calculator = calculator;
    }

    public static void main(String[] args) {
        SpringApplication.run(UvtApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOGGER.info("Received arguments {}", Arrays.toString(args));
        Set<Fragment> fragments = Arrays.stream(args)
                .map(tuple -> tuple.split("-"))
                .map(split -> new Fragment(Long.valueOf(split[0]), Long.valueOf(split[1])))
                .collect(Collectors.toSet());
        System.out.println(calculator.calculateUvt(fragments));
    }
}
