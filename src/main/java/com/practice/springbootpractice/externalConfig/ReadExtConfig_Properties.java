package com.practice.springbootpractice.externalConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("readextconfig")
public class ReadExtConfig_Properties {
	@Value("${server.port}")
	private int server_port;
	
	@Value("${app.groupid}")
	private String gav_info;
	
	public void getServerPort(){
		System.out.println("Server Port is - " + server_port);
	}

	public int getServer_port() {
		return server_port;
	}

	public void setServer_port(int server_port) {
		this.server_port = server_port;
	}

	public String getGav_info() {
		return gav_info;
	}

	public void setGav_info(String gav_info) {
		this.gav_info = gav_info;
	}
	
	
}
