package com.kdt.team04.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@GetMapping("/health")
	public String check() {
		return "health!!!";
	}

}
