package io.github.egd.prodigal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "io.github.egd.prodigal.repository.mapper")
public class InfrastructureConfig {

}
