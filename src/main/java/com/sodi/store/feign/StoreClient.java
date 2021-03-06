package com.sodi.store.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("stores")
public interface StoreClient {
	@RequestMapping(method = RequestMethod.GET, value = "/stores")
	List<Store> getStores();

	@RequestMapping(method = RequestMethod.GET, value = "/stores")
	Page<Store> getStores(Pageable pageable);

	@RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
	Store update(@PathVariable("storeId") Long storeId, Store store);
}