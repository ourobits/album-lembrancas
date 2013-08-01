/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.business;

import br.com.lembrancas.dao.IImagensDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author jacoboliveira
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TestBean implements TestBeanLocal {

    @EJB
    IImagensDao imagensDao;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List getImagens() throws Exception{
        return imagensDao.findAll();
    }
}
