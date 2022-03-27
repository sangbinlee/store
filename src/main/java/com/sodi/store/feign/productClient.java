package com.sodi.store.feign;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "productClient", url = "") 
public interface productClient {

    @GetMapping(value = "/test", produces = "application/json", consumes = "application/json")
    String testMethod(@RequestParam("key") String key);
    
    @PostMapping(value = "/user", produces = "application/json", consumes = "application/json")
    String registUser(@RequestHeader("auth-key") String authKey, @RequestBody User user);
}
