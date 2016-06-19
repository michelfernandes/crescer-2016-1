package br.com.crescer.services;

import br.com.crescer.entity.Pessoa;
import br.com.crescer.repository.PessoaRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PessoaService {
    
    @Autowired
    PessoaRepository repository;
    
    public List<Pessoa> list() {
        Pessoa p = new Pessoa();
        p.setNome("service");
        p.setNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }

    public Iterable<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa save(Pessoa p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}