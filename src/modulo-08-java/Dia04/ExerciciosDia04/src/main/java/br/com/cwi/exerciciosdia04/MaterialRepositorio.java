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
public class MaterialRepositorio implements IRepositorio<Material>{

    @Override
    public void insert(Material material) {
        ManagerUtils.session.persist(material);
    }

    @Override
    public void update(Material material) {
        ManagerUtils.session.merge(material);
    }

    @Override
    public void delete(Material material) {
        ManagerUtils.session.delete(material);
    }

    @Override
    public List<Material> listAll() {
        return ManagerUtils.session.createCriteria(Material.class).list();
    }
    
}
