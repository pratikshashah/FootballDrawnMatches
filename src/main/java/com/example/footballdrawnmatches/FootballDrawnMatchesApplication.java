package com.example.footballdrawnmatches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
@EnableAsync
@SpringBootApplication
public class FootballDrawnMatchesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballDrawnMatchesApplication.class, args);
	}

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Adjust as needed
        executor.setMaxPoolSize(10); // Adjust as needed
        executor.setQueueCapacity(25); // Adjust as needed
        executor.setThreadNamePrefix("TaskExecutor-");
        executor.initialize();
        return executor;
    }

}
