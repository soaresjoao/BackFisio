package com.fisioFinal.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class RestFullConfig extends ResourceConfig{
	public RestFullConfig(){
		packages("com.fisioFinal.service");
	}
}
