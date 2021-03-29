package com.muziqiu.Calculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class CalculatorController {
    private static final Logger log = LoggerFactory.getLogger(CalculatorController.class);

    CopyOnWriteArrayList<String> logs = new CopyOnWriteArrayList<String>();

    @CrossOrigin(origins = {"http://calculatorweb.muziqiu.com", "http://localhost:3000/"})
    @PostMapping("/calculatelog")
    public List<String> calculate(@RequestBody Map<String, String> singlecalculate) {
        logs.add(singlecalculate.get("singlecalculate"));
        log.info(String.valueOf(logs.size()));
        if(logs.size()>10){
            logs.remove(0);
        }
        return logs;
    }

    @GetMapping("/")
    public String index() {
        return "success";
    }
}
