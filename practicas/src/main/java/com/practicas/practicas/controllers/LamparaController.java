package com.practicas.practicas.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LamparaController {

    @RequestMapping(value = "prueba")
    public String prueba() {
        return "prueba";
    }

}
