package io.github.egd.prodigal.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动器
 */
@SpringBootApplication(scanBasePackages = "io.github.egd.prodigal")
public class SampleStarter {

    public static void main(String[] args) {
        SpringApplication.run(SampleStarter.class, args);
    }

}
