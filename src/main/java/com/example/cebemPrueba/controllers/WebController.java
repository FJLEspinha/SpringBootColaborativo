package com.example.cebemPrueba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/formulariofrases")
    public String getFormularioFrases(Model model){
        return "formularioFrases";
    }
}
