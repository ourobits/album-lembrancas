/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jacoboliveira
 */
@Entity
@Table(catalog = "album", schema = "")
@NamedQueries({
    @NamedQuery(name = "Lembrancas.findAll", query = "SELECT l FROM Lembrancas l")})
public class Lembrancas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String titulo;
    @Lob
    @Size(max = 2147483647)
    @Column(length = 2147483647)
    private String descricao;
    @Column(name = "data_insercao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInsercao;
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    @Size(max = 100)
    @Column(length = 100)
    private String usuario;
    private Boolean visivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_categoria", nullable = false)
    private long idCategoria;
    @OneToMany(mappedBy = "idFk", fetch = FetchType.LAZY)
    private List<Imagens> imagensList;

    public Lembrancas() {
    }

    public Lembrancas(Long id) {
        this.id = id;
    }

    public Lembrancas(Long id, String titulo, long idCategoria) {
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
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lembrancas.entities.Lembrancas[ id=" + id + " ]";
    }
    
}
