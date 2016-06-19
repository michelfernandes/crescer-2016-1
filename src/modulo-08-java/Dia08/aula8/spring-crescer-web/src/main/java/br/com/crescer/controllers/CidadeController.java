
package br.com.crescer.controllers;

import br.com.crescer.entity.Cidade;
import br.com.crescer.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cidade")
public class CidadeController {
    
    @Autowired
    CidadeService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id) {
        
        model.addAttribute("cidade", new Cidade());
        model.addAttribute("cidades", service.findAll());
        return "cidade-manutencao";
    }
//    
//    @RequestMapping(method = RequestMethod.POST)
//    public String salvar(@ModelAttribute Cidade c, Model model) {
//        
//        service.save(c);
//        return list(model, null);
//        
//    }
    
}
