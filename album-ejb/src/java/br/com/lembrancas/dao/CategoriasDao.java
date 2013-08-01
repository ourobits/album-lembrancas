/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.dao;

import br.com.lembrancas.dto.CategoriasDto;
import br.com.lembrancas.entities.Categorias;
import br.com.lembrancas.hibernate.GenericDao;
import br.com.lembrancas.util.Constants;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jacoboliveira
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CategoriasDao extends GenericDao<Categorias, Long> implements ICategoriasDao{

    @PersistenceContext(name = Constants.NAME_JNDI, unitName = Constants.UNIT_NAME)
    EntityManager entityManager;
    
    public CategoriasDao() {
    }
    
    @PostConstruct
    public void init(){
        init(entityManager);
    }
    
    public List<Categorias> buscarEntityList(CategoriasDto categoriasDto) throws Exception{
        return findAll();
    }
}
