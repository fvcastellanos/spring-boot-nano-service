package net.cavitos.benchmark.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.cavitos.benchmark.dao.ResourceDao;
import net.cavitos.benchmark.dao.ResourceStaticDao;

@Configuration
public class DaoConfiguration {

    @Bean
    public ResourceDao resourceStaticDao() {

        return new ResourceStaticDao();
    }
}
