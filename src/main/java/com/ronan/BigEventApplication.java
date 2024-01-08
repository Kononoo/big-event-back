package com.ronan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Slf4j
@SpringBootApplication
public class BigEventApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext context = SpringApplication.run(BigEventApplication.class, args);
        // 获取ip、服务配置文件
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String port = context.getEnvironment().getProperty("server.port");
        log.info("项目启动成功...");
        log.info("项目访问路径: {}:{}", hostAddress, port);
    }

}
