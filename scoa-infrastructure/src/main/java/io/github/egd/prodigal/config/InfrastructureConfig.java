package io.github.egd.prodigal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 基础设施层的配置类
 */
@Configuration
@MapperScan(basePackages = "io.github.egd.prodigal.repository.mapper")
public class InfrastructureConfig {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 初始化数据库信息
     */
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
