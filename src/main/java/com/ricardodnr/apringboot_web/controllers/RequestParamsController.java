package com.ricardodnr.apringboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ricardodnr.apringboot_web.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(
        @RequestParam(required=false, defaultValue = "Nada") String message
    ) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamDto bar(
        @RequestParam String message,
        @RequestParam Integer code
    ) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        paramDto.setCode(code);
        return paramDto;
    }

    @GetMapping("/request")
    public ParamDto request(
        HttpServletRequest request
    ) {

        Integer code = 0;

        try{
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ParamDto paramDto = new ParamDto();
        paramDto.setCode(code);
        paramDto.setMessage(request.getParameter("message"));
        return paramDto;
    }
}
