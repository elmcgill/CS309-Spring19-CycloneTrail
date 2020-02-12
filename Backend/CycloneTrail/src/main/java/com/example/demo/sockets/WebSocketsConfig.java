package com.example.demo.sockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.context.annotation.Bean;

@Configuration 
public class WebSocketsConfig {
	
	@Bean
	public ServerEndpointExporter severEndpointExporter() {
		return new ServerEndpointExporter();
	}
	
	
}
