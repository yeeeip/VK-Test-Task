package org.nuzhd.vktesttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.sql.DataSource;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class VkTestTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(VkTestTaskApplication.class, args);
    }

}
