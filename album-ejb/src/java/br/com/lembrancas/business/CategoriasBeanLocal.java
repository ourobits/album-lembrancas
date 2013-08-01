/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.business;

import br.com.lembrancas.dto.CategoriasDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jacoboliveira
 */
@Local
public interface CategoriasBeanLocal {

    public CategoriasDto salvar(CategoriasDto categoriasDto) throws Exception;
    
    public CategoriasDto excluir(CategoriasDto categoriasDto) throws Exception;
    
    public CategoriasDto findById(Long id) throws Exception;

    public List<CategoriasDto> buscarEntityList(CategoriasDto categoriasDto) throws Exception;
}
