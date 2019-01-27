package com.github.adrmal.peka.vm.client;

class PekaRequest {

	private String method;
	private String param;

	PekaRequest(String method, String param) {
		this.method = method;
		this.param = param;
	}

	String getMethod() {
		return method;
	}

	String getParam() {
		return param;
	}

}
