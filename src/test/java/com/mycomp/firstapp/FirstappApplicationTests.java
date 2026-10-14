package com.mycomp.firstapp;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FirstappApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void addsNumbersAndReturnsTheSumAsJson() throws Exception {
		mockMvc.perform(get("/api/add").param("a", "2").param("b", "3"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.sum").value(5));
	}

	@Test
	void addsNegativeNumbers() throws Exception {
		mockMvc.perform(get("/api/add").param("a", "-2").param("b", "3"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.sum").value(1));
	}

	@Test
	void addsLargeNumbersWithoutOverflow() throws Exception {
		mockMvc.perform(get("/api/add").param("a", "9223372036854775807").param("b", "1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.sum").value(new BigInteger("9223372036854775808")));
	}

	@Test
	void acceptsStripeWebhookJsonAndReturnsOk() throws Exception {
		mockMvc.perform(post("/webhook")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"type\":\"payment_intent.succeeded\"}"))
				.andExpect(status().isOk());
	}
}
