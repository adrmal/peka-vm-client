package com.github.adrmal.peka.vm.client;

class PekaRequestBuilder {

	private String method;
	private String param;

	PekaRequestBuilder withMethod(String method) {
		this.method = method;
		return this;
	}

	PekaRequestBuilder withParam(String paramName, String paramValue) {
		this.param = "{\"" + paramName + "\":\"" + paramValue + "\"}";
		return this;
	}

    PekaRequestBuilder withEmptyParam() {
        this.param = "{}";
        return this;
    }

	PekaRequest build() {
		return new PekaRequest(method, param);
	}

	static PekaRequestBuilder builder() {
		return new PekaRequestBuilder();
	}

}
