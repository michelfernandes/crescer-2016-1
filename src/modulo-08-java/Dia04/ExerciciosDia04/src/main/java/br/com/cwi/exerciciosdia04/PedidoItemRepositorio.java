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
public class PedidoItemRepositorio implements IRepositorio<PedidoItem>{

    @Override
    public void insert(PedidoItem pedidoItem) {
        ManagerUtils.session.persist(pedidoItem);
    }

    @Override
    public void update(PedidoItem pedidoItem) {
        ManagerUtils.session.merge(pedidoItem);
    }

    @Override
    public void delete(PedidoItem pedidoItem) {
        ManagerUtils.session.delete(pedidoItem);
    }

    @Override
    public List<PedidoItem> listAll() {
        return ManagerUtils.session.createCriteria(PedidoItem.class).list();
    }
    
}
