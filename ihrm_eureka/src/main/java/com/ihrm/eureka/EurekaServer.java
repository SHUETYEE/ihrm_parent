package com.ihrm.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 李靖宇
 * @Project ihrm_parent
 * @date 2019/12/19 16:22
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
/**
 * eureka服务端的启动类
 */
@SpringBootApplication
// @EnableEurekaServer//开启eureka服务端配置
public class EurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class,args);
    }
}
