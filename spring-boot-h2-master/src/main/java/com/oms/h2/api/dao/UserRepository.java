package com.oms.h2.api.dao;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.oms.h2.api.model.UserResponse;

@FeignClient(url="https://jsonplaceholder.typicode.com",name="USER-CLIENT")
public interface UserRepository {

	@GetMapping("/users")
	public List<UserResponse> getUsers();
}
