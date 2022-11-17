package me.junhua.oauth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@Slf4j
@SpringCloudApplication
public class JunhuaOauthApplication {

    public static void main(String[] args) {
        log.info("############===认证服务开始启动===############");
        SpringApplication.run(JunhuaOauthApplication.class, args);
        log.info("############===认证服务启动成功===############");
    }
}
