package study.ddd.skeleton.shared.infrastructure.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class EnviromentConfig {
    ResourceLoader resourceLoader;

    public EnviromentConfig(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public Dotenv dotenv() {
        Resource resource = resourceLoader.getResource("classpath:/.env.local");

        return Dotenv
                .configure()
                .directory("D:\\dev\\Study\\DDD\\skeleton")
                .filename(resource.exists() ? ".env.local" : ".env")
                .load();
    }

}