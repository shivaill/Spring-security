package com.objectfrontier.ecapp.entity;

public enum AuthenticationType {
	REST_POST("REST_POST"),
	REST_GET("REST_GET"),
	SOAP("SOAP");
	
	String authenticationType;
	
	private AuthenticationType(String authenticationType){
		this.authenticationType = authenticationType;
	}
	
	public String getAuthenticationType(){
		return authenticationType;
	}
	
}
