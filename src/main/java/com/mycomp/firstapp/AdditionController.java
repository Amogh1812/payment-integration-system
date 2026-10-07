package com.mycomp.firstapp;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

	private static final Logger logger = LoggerFactory.getLogger(AdditionController.class);

	@GetMapping("/api/add")
	public SumResponse add(@RequestParam BigInteger a, @RequestParam BigInteger b) {
		logger.info("Adding numbers: a={}, b={}", a, b);
		SumResponse response = new SumResponse(a.add(b));
		logger.info("Returning sum: {}", response.sum());
		return response;
	}

	public record SumResponse(BigInteger sum) {
	}
}
