/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.dto;

import br.com.lembrancas.annotation.Campo;
import java.io.Serializable;

/**
 *
 * @author jacoboliveira
 */
public class CategoriasDto implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long id;
    @Campo(mensagem="Preencha o campo titulo!",obrigatorio=true)
    private String titulo;
    private String descricao;
    private Boolean ativarSeguranca;
    private Boolean visivel;
    private String usuario;

    public CategoriasDto() {
    }

    public CategoriasDto(Long id) {
        this.id = id;
    }

    public CategoriasDto(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivarSeguranca() {
        return ativarSeguranca;
    }

    public void setAtivarSeguranca(Boolean ativarSeguranca) {
        this.ativarSeguranca = ativarSeguranca;
    }

    public Boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(Boolean visivel) {
        this.visivel = visivel;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriasDto)) {
            return false;
        }
        CategoriasDto other = (CategoriasDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lembrancas.entities.Categorias[ id=" + id + " ]";
    }
}
