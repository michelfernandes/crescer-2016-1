package br.com.crescer.controllers;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.services.PessoaService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    PessoaService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        
        model.addAttribute("pessoa", new Pessoa());
        model.addAttribute("pessoas", service.findAll());
        return "pessoa-manutencao";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@ModelAttribute Pessoa p, Model model) {
        if (p.getNascimento() == null) {
            p.setNascimento(new Date());
        }
        service.save(p);
        return list(model);
    }
    
    @RequestMapping(value="/delete",method = RequestMethod.GET)
    public String delete(@RequestParam ("id") Long id, Model model) {
        
        service.delete(id);
        return list(model);
    }  
    
}