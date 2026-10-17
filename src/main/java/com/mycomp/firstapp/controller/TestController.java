package com.mycomp.firstapp.controller;

import com.mycomp.firstapp.pojo.MYreq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.json.JsonMapper;

@RestController
@RequestMapping("/api/test")
@Slf4j
public class TestController {

    private final JsonMapper jsonMapper;

    public TestController(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/m1")
    public String testEndpointA() {
        log.info("m1 endpouunt");
        return "Test endpoint is working!";
    }

    @GetMapping("/m2")
    public String testEndpointB() {
        log.info("m2 endpoint accessed");
        return "Test endpoint 2 is working!";
    }

    @PostMapping("/m3")
    public MYreq parseRequested(@RequestBody String json) {
        MYreq request = jsonMapper.readValue(json, MYreq.class);
        log.info("Parsed request: vale1={}, val2={}", request.getVale1(), request.getVal2());
        return request;

    }

}
