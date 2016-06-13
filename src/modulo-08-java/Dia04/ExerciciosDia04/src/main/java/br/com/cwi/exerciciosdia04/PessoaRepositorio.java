/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.exerciciosdia04;

import java.util.List;

/**
 *
 * @author Michel
 */
public class PessoaRepositorio implements IRepositorio<Pessoa>{

    @Override
    public void insert(Pessoa pessoa) {
         ManagerUtils.session.persist(pessoa);
    }

    @Override
    public void update(Pessoa pessoa) {
         ManagerUtils.session.merge(pessoa);
    }

    @Override
    public void delete(Pessoa pessoa) {
         ManagerUtils.session.delete(pessoa);
    }

    @Override
    public List<Pessoa> listAll() {
         return ManagerUtils.session.createCriteria(Pessoa.class).list();
    }
    
}
