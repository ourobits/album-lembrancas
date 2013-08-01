/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.web;

import br.com.lembrancas.annotation.ManagerAnnotationDto;
import br.com.lembrancas.business.CategoriasBeanLocal;
import br.com.lembrancas.dto.CategoriasDto;
import br.com.lembrancas.web.exceptions.TratamentoException;
import br.com.lembrancas.web.faces.FacesBean;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author jacoboliveira
 */
public class HomePage extends FacesBean {

    @EJB
    CategoriasBeanLocal categoriasBeanLocal;
    TratamentoException tratamentoException;
    ManagerAnnotationDto managerAnnotationDto;
    SelectItem[] categorias;
    CategoriasDto categoriasDto;

    public SelectItem[] getCategorias() {
        try {
            List<SelectItem> listOptions = new ArrayList<SelectItem>();
            List<CategoriasDto> list = categoriasBeanLocal.buscarEntityList(null);

            for (CategoriasDto categoriasDto : list) {
                listOptions.add(new SelectItem(categoriasDto.getId(), categoriasDto.getTitulo()));
            }
            categorias = listOptions.toArray(new SelectItem[listOptions.size()]);
        } catch (Exception ex) {
            tratamentoException.tratar(ex);
        }
        return categorias;
    }

    public void novo() {
        setBean("CategoriasDto", new CategoriasDto());
    }

    public void salvar() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        boolean result = false;
        try {
            CategoriasDto categoriaDto = getCategoriasDto();
            managerAnnotationDto.analizarCamposObrigatorios(categoriaDto);
            categoriasBeanLocal.salvar(categoriaDto);
            setBean("CategoriasDto", new CategoriasDto());
            info("Categoria inserida com sucesso!");
            result = true;
        } catch (Exception ex) {
            tratamentoException.tratar(ex);
            result = false;
        }
        requestContext.addCallbackParam("resultado", result);
    }

    public void alterarCategoria(){
     
    }
    
    public void excluir() {
        try {
            if (categoriasDto != null) {
                categoriasBeanLocal.excluir(this.categoriasDto);
                info("Categoria excluida com sucesso");
                categoriasDto = null;
            }
        } catch (Exception ex) {
            tratamentoException.tratar(ex);
        }
    }

    public void categoriaSelecionada(ValueChangeEvent e) {
        Long id = Long.valueOf(e.getNewValue().toString());
        try {
            this.categoriasDto = categoriasBeanLocal.findById(id);
        } catch (Exception ex) {
            tratamentoException.tratar(ex);
        }
    }

    public CategoriasDto getCategoriasDto() {
        return (CategoriasDto) getBean("categoriasDto", CategoriasDto.class);
    }

    @PostConstruct
    public void init() {
        tratamentoException = new TratamentoException();
        managerAnnotationDto = new ManagerAnnotationDto();
        getCategorias();
    }
}
