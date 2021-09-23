package com.zuson.demo.websocketutil;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author 孙书洋
 * @ClassName: WebSocketConfig
 * @projectName environmentserver
 * @description: TODO
 * @date 2020/1/2 9:18
 * @version:1.0
 */
@Configuration
@ConditionalOnWebApplication
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
