package io.github.egd.prodigal.test.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.github.egd.prodigal")
public class ScoaAppStarter {

    public static void main(String[] args) {
        SpringApplication.run(ScoaAppStarter.class, args);
    }

}
