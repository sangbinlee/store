package com.sodi.store.feign;

import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "test", url = "http://localhost:${server.port}/", fallback = Fallback.class)
public interface TestClient {

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	Hello getHello();

	@RequestMapping(method = RequestMethod.GET, value = "/hellonotfound")
	String getException();

}

@Component
class Fallback implements TestClient {

	@Override
	public Hello getHello() {
		throw new NoFallbackAvailableException("Boom!", new RuntimeException());
	}

	@Override
	public String getException() {
		return "Fixed response";
	}

}