package com.mycomp.firstapp;

import java.math.BigInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

	@GetMapping("/api/add")
	public SumResponse add(@RequestParam BigInteger a, @RequestParam BigInteger b) {
		return new SumResponse(a.add(b));
	}

	public record SumResponse(BigInteger sum) {
	}
}
