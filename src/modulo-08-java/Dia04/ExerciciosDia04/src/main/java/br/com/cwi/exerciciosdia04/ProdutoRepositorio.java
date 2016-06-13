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
public class ProdutoRepositorio implements IRepositorio<Produto>{

    @Override
    public void insert(Produto produto) {
         ManagerUtils.session.persist(produto);
    }

    @Override
    public void update(Produto produto) {
         ManagerUtils.session.merge(produto);
    }

    @Override
    public void delete(Produto produto) {
         ManagerUtils.session.delete(produto);
    }

    @Override
    public List<Produto> listAll() {
         return ManagerUtils.session.createCriteria(Produto.class).list();
    }
    
}
