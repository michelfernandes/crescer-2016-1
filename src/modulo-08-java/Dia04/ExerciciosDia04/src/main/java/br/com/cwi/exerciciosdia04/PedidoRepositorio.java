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
public class PedidoRepositorio implements IRepositorio<Pedido>{

    @Override
    public void insert(Pedido pedido) {
         ManagerUtils.session.persist(pedido);
    }

    @Override
    public void update(Pedido pedido) {
          ManagerUtils.session.merge(pedido);
    }

    @Override
    public void delete(Pedido pedido) {
         ManagerUtils.session.delete(pedido);
    }

    @Override
    public List<Pedido> listAll() {
        return ManagerUtils.session.createCriteria(Pedido.class).list();
    }
    
}
