package com.ihrm.company;

import com.ihrm.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/16 16:38
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@SpringBootApplication(scanBasePackages = "com.ihrm.company")
@EntityScan(value = "com.ihrm.domain.company")

public class CompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
