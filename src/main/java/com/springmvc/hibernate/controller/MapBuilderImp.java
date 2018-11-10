package com.springmvc.hibernate.controller;

import org.json.JSONObject;

public class MapBuilderImp implements MapBuilder{

	private  JSONObject mapRequest;

	@Override
	public void setMapBuilder(JSONObject request) {
		this.mapRequest=request;
		
	}

	@Override
	public JSONObject getMapBuilder() {
		return this.mapRequest;
	}
	
}
