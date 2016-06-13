
package br.com.cwi.exerciciosdia04;

import java.util.List;

/**
 *
 * @author Michel
 */
public class CidadeRepositorio implements IRepositorio<Cidade>{

    @Override
    public List listAll() {
        return ManagerUtils.session.createCriteria(Cidade.class).list();
    }

    @Override
    public void insert(Cidade cidade) {
        ManagerUtils.session.persist(cidade);
    }

    @Override
    public void update(Cidade cidade) {
        ManagerUtils.session.merge(cidade);
    }

    @Override
    public void delete(Cidade cidade) {
        ManagerUtils.session.delete(cidade);
    }
    
}
