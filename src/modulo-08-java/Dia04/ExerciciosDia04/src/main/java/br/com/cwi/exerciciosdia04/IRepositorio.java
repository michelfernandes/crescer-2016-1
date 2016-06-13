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
public interface IRepositorio<Object> {
    
     void insert(Object object);
     void update(Object object);
     void delete(Object object);
     List<Object> listAll();
    
}
