/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.dto;

import br.com.lembrancas.entities.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jacoboliveira
 */
public class LembrancasDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String titulo;
    private String descricao;
    private Date dataInsercao;
    private Date dataAtualizacao;
    private String usuario;
    private Boolean visivel;
    private long idCategoria;
    private List<Imagens> imagensList;

    public LembrancasDto() {
    }

    public LembrancasDto(Long id) {
        this.id = id;
    }

    public LembrancasDto(Long id, String titulo, long idCategoria) {
        this.id = id;
        this.titulo = titulo;
        this.idCategoria = idCategoria;
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

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(Boolean visivel) {
        this.visivel = visivel;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<Imagens> getImagensList() {
        return imagensList;
    }

    public void setImagensList(List<Imagens> imagensList) {
        this.imagensList = imagensList;
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
        if (!(object instanceof Lembrancas)) {
            return false;
        }
        Lembrancas other = (Lembrancas) object;
        if ((this.id == null && other.getId() != null) || (this.id != null && !this.id.equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lembrancas.entities.Lembrancas[ id=" + id + " ]";
    }
    
}
