package com.mycomp.firstapp.controller;

import java.math.BigInteger;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.firstapp.service.impl.Mathimp;
import com.mycomp.firstapp.service.interfaces.MathService;

@RestController
@Slf4j
public class MathController {

    @Value("${db_ip}")
    private String dbIp;

    // @Autowired
    // private MathService mathService;
    private final MathService mathService;

    MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @PostConstruct
    public void logDbIp() {
        log.info("Configured db_ip: {}", dbIp);
        log.info("MathService impl: {}", mathService);
    }

    @GetMapping("/math/add")
    public String add(@RequestParam int a, @RequestParam int b) {
        log.info("Configured db_ip: {}", dbIp);
        log.info("Adding numbers: a={}, b={}", a, b);
        // MathService mathService = new Mathimp();
        int sum = mathService.add(a, b);
        log.info("Returning sum: {}", sum);
        return "sums is:" + sum;
    }

    public record SumResponse(BigInteger sum) {
    }
}
