package com.sodi.store.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreApi {

	@GetMapping("test")
	public String test() {
		return "test";
	}
}
