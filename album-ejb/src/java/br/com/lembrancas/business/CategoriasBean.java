/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.business;

import br.com.lembrancas.dao.ICategoriasDao;
import br.com.lembrancas.dto.CategoriasDto;
import br.com.lembrancas.entities.Categorias;
import br.com.lembrancas.util.BeanHelper;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

/**
 *
 * @author jacoboliveira
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CategoriasBean implements CategoriasBeanLocal {

    @EJB
    ICategoriasDao categoriasDao;

    public CategoriasBean() {
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public CategoriasDto salvar(CategoriasDto categoriasDto) throws Exception {
        Categorias categorias = BeanHelper.copyProps(categoriasDto, new Categorias());
        categorias.setDataInsercao(new Date(System.currentTimeMillis()));
        categorias.setDataAtualizacao(new Date(System.currentTimeMillis()));

        categoriasDao.save(categorias);

        return BeanHelper.copyProps(categorias, categoriasDto);
    }

    public CategoriasDto findById(Long id) throws Exception {
        return BeanHelper.copyProps(categoriasDao.findById(id), new CategoriasDto());
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public CategoriasDto excluir(CategoriasDto categoriasDto) throws Exception {
        Categorias categorias = categoriasDao.findById(categoriasDto.getId());
        categoriasDao.delete(categorias);
        return categoriasDto;
    }

    public List<CategoriasDto> buscarEntityList(CategoriasDto categoriasDto) throws Exception {
        List list = categoriasDao.buscarEntityList(categoriasDto);
        CollectionUtils.transform(list, new Transformer() {
            @Override
            public Object transform(Object o) {
                CategoriasDto categoriasDto = BeanHelper.copyProps(o, new CategoriasDto());
                return categoriasDto;
            }
        });
        return list;
    }
}
