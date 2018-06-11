package com.opendevup.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.opendevup.hundler.CounterHandler;
import com.opendevup.hundler.CounterHandlerMsg;

@Configuration
@EnableWebSocket
@EnableScheduling
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    CounterHandler counterHandler;
    @Autowired 
    CounterHandlerMsg counterHandlerMsg;

    @Override
    public void registerWebSocketHandlers( WebSocketHandlerRegistry registry ) {
        registry.addHandler( counterHandler, "/counter" ).setAllowedOrigins( "*" );
        registry.addHandler( counterHandlerMsg, "/counterMsg").setAllowedOrigins("*");
    }

}
