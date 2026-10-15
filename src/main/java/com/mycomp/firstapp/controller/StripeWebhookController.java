package com.mycomp.firstapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StripeWebhookController {

	@PostMapping("/webhook")
	public ResponseEntity<Void> receiveWebhook(@RequestBody String json) {
		log.info("Received Stripe webhook: {}", json);
		return ResponseEntity.ok().build();
	}
}
