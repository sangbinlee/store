package com.sodi.store.feign;

import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "testClientWithFactory", url = "http://localhost:${server.port}/", fallbackFactory = TestFallbackFactory.class)
interface TestClientWithFactory {

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	Hello getHello();

	@RequestMapping(method = RequestMethod.GET, value = "/hellonotfound")
	String getException();

}

@Component
class TestFallbackFactory implements FallbackFactory<FallbackWithFactory> {

	@Override
	public FallbackWithFactory create(Throwable cause) {
		return new FallbackWithFactory();
	}

}

class FallbackWithFactory implements TestClientWithFactory {

	@Override
	public Hello getHello() {
		throw new NoFallbackAvailableException("Boom!", new RuntimeException());
	}

	@Override
	public String getException() {
		return "Fixed response";
	}

}