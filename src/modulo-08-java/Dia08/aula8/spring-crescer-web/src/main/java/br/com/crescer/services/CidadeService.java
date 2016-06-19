package br.com.crescer.services;

import br.com.crescer.entity.Cidade;
import br.com.crescer.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michel
 */
@Service
public class CidadeService {
    
    @Autowired
    CidadeRepository repository;   

    public Iterable<Cidade> findAll() {
        return repository.findAll();
    }

    public Cidade save(Cidade c) {
        return repository.save(c);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
    
}
