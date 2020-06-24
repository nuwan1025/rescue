package com.nuwank.rescue;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class to represent the spring main configurations and bindings.
 */
@Configuration
@EnableScheduling
public class SpringMainConfig {

    /**
     * Method to provide the executor service.
     *
     * @return the executor service
     */
    @Bean
    @Qualifier("cachedThreadPoolTaskExecutor")
    public ExecutorService getTaskExecutor() {
        return Executors.newCachedThreadPool();
    }

}
