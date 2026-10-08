package com.mycomp.firstapp;

import java.math.BigInteger;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AdditionController {

	@Value("${db_ip}")
	private String dbIp;

	@PostConstruct
	public void logDbIp() {
		log.info("Configured db_ip: {}", dbIp);
	}

	@GetMapping("/api/add")
	public SumResponse add(@RequestParam BigInteger a, @RequestParam BigInteger b) {
		log.info("Configured db_ip: {}", dbIp);
		log.info("Adding numbers: a={}, b={}", a, b);
		SumResponse response = new SumResponse(a.add(b));
		log.info("Returning sum: {}", response.sum());
		return response;
	}

	public record SumResponse(BigInteger sum) {
	}
}
