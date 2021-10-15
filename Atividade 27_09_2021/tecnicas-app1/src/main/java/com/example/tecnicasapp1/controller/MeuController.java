package com.example.tecnicasapp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MeuController {

    @RequestMapping("/materia")
    public String helloWorld(Model model) {
        return "index";
    }

}
