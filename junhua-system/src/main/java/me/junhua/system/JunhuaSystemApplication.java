package me.junhua.system;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@Slf4j
@SpringCloudApplication
public class JunhuaSystemApplication {

    public static void main(String[] args) {
        log.info("############===系统服务开始启动===############");
        SpringApplication.run(JunhuaSystemApplication.class, args);
        log.info("############===系统服务启动成功===############");
    }
}
