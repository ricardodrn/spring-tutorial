package com.ricardodnr.apringboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardodnr.apringboot_web.models.User;
import com.ricardodnr.apringboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/v1")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.lista}")
    private List<String> lista;

    @Value("#{ '${config.listOfValues}'.split(',') }")
    private List<String> valueList;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String productName;

    @Value("#{${config.valuesMap}.price}")
    private String productPrice;

    @Autowired
    private Environment environment;

    @GetMapping("baz/{message}")
    public ParamDto baz(
        @PathVariable String message
    ) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("buz/{message}/{code}")
    public Map<String, Object> buz(
        @PathVariable String message,
        @PathVariable Long code
    ) {
        Map<String, Object> json = new HashMap<>();
        json.put("message", message);
        json.put("code", code);
        return json;
    }

    @PostMapping("/create")
    public User create(
        @RequestBody User user
    ) {
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/config")
    public Map<String, Object> config(
        @Value("${config.code}") Long code
    ) {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", message);
        json.put("message2", environment.getProperty("config.message"));
        json.put("code2", environment.getProperty("config.code", Long.class));
        json.put("lista", lista);
        json.put("code", code);
        json.put("valueList", valueList);
        json.put("valuesMap", valuesMap);
        json.put("product", productName);
        json.put("price", productPrice);
        return json;
    }
}
