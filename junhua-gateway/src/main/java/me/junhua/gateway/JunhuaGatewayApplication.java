package me.junhua.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@Slf4j
@SpringCloudApplication
public class JunhuaGatewayApplication {

    public static void main(String[] args) {
        log.info("############===网关服务开始启动===############");
        SpringApplication.run(JunhuaGatewayApplication.class, args);
        log.info("############===网关服务启动成功===############");
    }
}
