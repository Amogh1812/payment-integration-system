package com.mycomp.firstapp.controller;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.firstapp.service.interfaces.MathService;
import tools.jackson.databind.json.JsonMapper;

@RestController
@Slf4j
public class MathController {

    @Value("${db_ip}")
    private String dbIp;

    // Direct constructor injection alternative:
    // private final MathService mathService;
    //
    // public MathController(MathService mathService) {
    // this.mathService = mathService;
    // }

    private final ApplicationContext applicationContext;
    private final JsonMapper jsonMapper;

    public MathController(ApplicationContext applicationContext, JsonMapper jsonMapper) {
        this.applicationContext = applicationContext;
        this.jsonMapper = jsonMapper;
    }

    @PostConstruct
    public void logDbIp() {
        log.info("Configured db_ip: {}", dbIp);
        log.info("ApplicationContext initialized: {}", applicationContext);
    }

    private void printAllBeans() {
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            log.info("Spring bean: {}", beanName);
        }
    }

    @GetMapping(value = "/math/add", produces = "application/json")
    public String add(@RequestParam int a, @RequestParam int b) {
        printAllBeans();
        log.info("Configured db_ip: {}", dbIp);
        log.info("Adding numbers: a={}, b={}", a, b);
        // printAllBeans();
        MathService mathService = applicationContext.getBean(MathService.class);
        int sum = mathService.add(a, b);
        log.info("Returning sum: {}", sum);
        Map<String, Integer> values = new LinkedHashMap<>();
        values.put("A", a);
        values.put("b", b);
        return jsonMapper.writeValueAsString(values);
    }

    public record SumResponse(BigInteger sum) {
    }
}
