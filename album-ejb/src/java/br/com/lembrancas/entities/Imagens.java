/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.entities;

import br.com.lembrancas.hibernate.IEntity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author jacoboliveira
 */
@Entity
@Table(catalog = "album", schema = "")
public class Imagens implements IEntity<Long>,Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "caminho_imagem", length = 255)
    private String caminhoImagem;
    @JoinColumn(name = "id_fk", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lembrancas idFk;

    public Imagens() {
    }

    public Imagens(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Lembrancas getIdFk() {
        return idFk;
    }

    public void setIdFk(Lembrancas idFk) {
        this.idFk = idFk;
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
        if (!(object instanceof Imagens)) {
            return false;
        }
        Imagens other = (Imagens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.lembrancas.entities.Imagens[ id=" + id + " ]";
    }
    
}
