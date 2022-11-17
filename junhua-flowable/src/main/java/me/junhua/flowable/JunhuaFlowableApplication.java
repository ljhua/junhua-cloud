package me.junhua.flowable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@Slf4j
@SpringCloudApplication
public class JunhuaFlowableApplication {

    public static void main(String[] args) {
        log.info("############===工作流服务开始启动===############");
        SpringApplication.run(JunhuaFlowableApplication.class, args);
        log.info("############===工作流服务启动成功===############");
    }
}
