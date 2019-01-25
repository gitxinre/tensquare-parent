package com.xinre.recruit;

import com.xinre.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author xinre
 * @date 2019/1/18 13:39
 */
@SpringBootApplication
public class RecruitApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecruitApplication.class, args);
    }

    @Bean
    public IdWorker getNextId() {
        return new IdWorker();
    }
}
