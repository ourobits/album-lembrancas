/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.dao;

import br.com.lembrancas.entities.Imagens;
import br.com.lembrancas.hibernate.IGenericDao;
import javax.ejb.Local;

/**
 *
 * @author jacoboliveira
 */
@Local
public interface IImagensDao extends IGenericDao<Imagens, Long> {
    
}
