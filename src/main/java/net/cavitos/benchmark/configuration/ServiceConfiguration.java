package net.cavitos.benchmark.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.cavitos.benchmark.dao.ResourceDao;
import net.cavitos.benchmark.service.ResourceService;

@Configuration
public class ServiceConfiguration {

    @Bean
    public ResourceService resourceService(ResourceDao resourceDao) {

        return new ResourceService(resourceDao);
    }
}