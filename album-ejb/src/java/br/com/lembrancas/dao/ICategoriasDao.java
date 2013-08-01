/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.dao;

import br.com.lembrancas.dto.CategoriasDto;
import br.com.lembrancas.entities.Categorias;
import br.com.lembrancas.hibernate.IGenericDao;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jacoboliveira
 */
@Local
public interface ICategoriasDao extends IGenericDao<Categorias, Long> {
    public List<Categorias> buscarEntityList(CategoriasDto categoriasDto) throws Exception;
}
