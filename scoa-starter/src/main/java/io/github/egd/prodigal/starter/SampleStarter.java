package io.github.egd.prodigal.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.nio.charset.Charset;

@SpringBootApplication(scanBasePackages = "io.github.egd.prodigal")
public class SampleStarter {

    public static void main(String[] args) {
        SpringApplication.run(SampleStarter.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public ApplicationRunner initDB() {
        return args -> {
            ClassPathResource resource = new ClassPathResource("init/init.sql");
            InputStream inputStream = resource.getInputStream();
            String sql = StreamUtils.copyToString(inputStream, Charset.defaultCharset());
            jdbcTemplate.execute(sql);
        };
    }

}
