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
public class ProdutoMaterialRepositorio implements IRepositorio<ProdutoMaterial>{

    @Override
    public void insert(ProdutoMaterial produtoMaterial) {
         ManagerUtils.session.persist(produtoMaterial);
    }

    @Override
    public void update(ProdutoMaterial produtoMaterial) {
         ManagerUtils.session.merge(produtoMaterial);
    }

    @Override
    public void delete(ProdutoMaterial produtoMaterial) {
         ManagerUtils.session.delete(produtoMaterial);
    }

    @Override
    public List<ProdutoMaterial> listAll() {
         return ManagerUtils.session.createCriteria(ProdutoMaterial.class).list();
    }
    
}
