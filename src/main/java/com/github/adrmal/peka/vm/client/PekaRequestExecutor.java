package com.github.adrmal.peka.vm.client;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;

class PekaRequestExecutor {

	private static final Client REST_CLIENT = ResteasyClientBuilder.newClient();
	private static final String BASE_URL = "http://www.peka.poznan.pl/vm/method.vm";
	private static final String METHOD_PARAM = "method";
	private static final String P0_PARAM = "p0";
	private static final String CHARSET_UTF8 = "; charset=UTF-8";

	String execute(PekaRequest request) {
		Response response = REST_CLIENT.target(BASE_URL)
				.request()
				.header(CONTENT_TYPE, APPLICATION_FORM_URLENCODED + CHARSET_UTF8)
				.post(getRequestBody(request));

		return response.readEntity(String.class);
	}

	private Entity getRequestBody(PekaRequest request) {
		Form form = new Form();
		form.param(METHOD_PARAM, request.getMethod());
		if(request.getParam() != null) {
			form.param(P0_PARAM, request.getParam());
		}

		return Entity.form(form);
	}

}
