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
public class ClienteRepositorio implements IRepositorio<Cliente>{

    @Override
    public void insert(Cliente cliente) {
        ManagerUtils.session.persist(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        ManagerUtils.session.merge(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        ManagerUtils.session.delete(cliente);
    }

    @Override
    public List<Cliente> listAll() {
        return ManagerUtils.session.createCriteria(Cliente.class).list();
    }
    
}
