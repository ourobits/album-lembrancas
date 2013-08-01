/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.dao;

import br.com.lembrancas.entities.Imagens;
import br.com.lembrancas.hibernate.GenericDao;
import br.com.lembrancas.util.Constants;
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
public class ImagensDao extends GenericDao<Imagens, Long> implements IImagensDao {

    @PersistenceContext(name = Constants.NAME_JNDI, unitName = Constants.UNIT_NAME)
    EntityManager entityManager;

    public ImagensDao() {
    }

    @PostConstruct
    public void init() {
        init(entityManager);
    }
}
