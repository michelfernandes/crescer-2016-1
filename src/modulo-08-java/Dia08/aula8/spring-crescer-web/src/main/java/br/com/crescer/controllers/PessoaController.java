package br.com.crescer.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Example {

    @RequestMapping(value = "/")
    String toIndex(Model model) {
        model.addAttribute("name", "Teste");
        return "index";
    }

}