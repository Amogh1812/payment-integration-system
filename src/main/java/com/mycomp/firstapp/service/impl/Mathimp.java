package com.mycomp.firstapp.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mycomp.firstapp.service.interfaces.MathService;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Mathimp implements MathService {
    @Value("${db_ip}")
    private String dbIp;

    @PostConstruct
    public void logDbIp() {
        log.info("Configured db_ip: {}", dbIp);
    }

    @Override
    public int add(int val1, int val2) {
        log.info("Adding values: val1={}, val2={}", val1, val2);
        int result = val1 + val2;
        log.info("ADD=======>", dbIp);
        log.info("Addition result: {}", result);
        return result;
    }
}
