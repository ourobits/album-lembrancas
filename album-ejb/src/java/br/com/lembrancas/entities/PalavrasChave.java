/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "palavras_chave", catalog = "album", schema = "")
@NamedQueries({
    @NamedQuery(name = "PalavrasChave.findAll", query = "SELECT p FROM PalavrasChave p")})
public class PalavrasChave implements Serializable {
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
    private String nome;
    @Column(name = "data_insercao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInsercao;
    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id", nullable = false)
    private long fkId;

    public PalavrasChave() {
    }

    public PalavrasChave(Long id) {
        this.id = id;
    }

    public PalavrasChave(Long id, String nome, long fkId) {
        this.id = id;
        this.nome = nome;
        this.fkId = fkId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public long getFkId() {
        return fkId;
    }

    public void setFkId(long fkId) {
        this.fkId = fkId;
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
        if (!(object instanceof PalavrasChave)) {
            return false;
        }
        PalavrasChave other = (PalavrasChave) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lembrancas.entities.PalavrasChave[ id=" + id + " ]";
    }
    
}
