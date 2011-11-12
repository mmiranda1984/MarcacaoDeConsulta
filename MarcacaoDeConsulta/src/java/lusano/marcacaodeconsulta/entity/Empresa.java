/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mmiranda1984
 */
@Entity
@Table(name = "EMPRESA", catalog = "MARCACAODECONSULTA", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByCodEmpresa", query = "SELECT e FROM Empresa e WHERE e.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "Empresa.findByNomEmpresa", query = "SELECT e FROM Empresa e WHERE e.nomEmpresa = :nomEmpresa"),
    @NamedQuery(name = "Empresa.findByTxtEmailEmpresa", query = "SELECT e FROM Empresa e WHERE e.txtEmailEmpresa = :txtEmailEmpresa"),
    @NamedQuery(name = "Empresa.findByIndAtivo", query = "SELECT e FROM Empresa e WHERE e.indAtivo = :indAtivo")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_EMPRESA")
    private Integer codEmpresa;
    @Basic(optional = false)
    @Column(name = "NOM_EMPRESA")
    private String nomEmpresa;
    @Basic(optional = false)
    @Column(name = "TXT_EMAIL_EMPRESA")
    private String txtEmailEmpresa;
    @Basic(optional = false)
    @Column(name = "IND_ATIVO")
    private boolean indAtivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private Collection<Filial> filialCollection;

    public Empresa() {
    }

    public Empresa(Integer codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public Empresa(Integer codEmpresa, String nomEmpresa, String txtEmailEmpresa, boolean indAtivo) {
        this.codEmpresa = codEmpresa;
        this.nomEmpresa = nomEmpresa;
        this.txtEmailEmpresa = txtEmailEmpresa;
        this.indAtivo = indAtivo;
    }

    public Integer getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Integer codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getTxtEmailEmpresa() {
        return txtEmailEmpresa;
    }

    public void setTxtEmailEmpresa(String txtEmailEmpresa) {
        this.txtEmailEmpresa = txtEmailEmpresa;
    }

    public boolean getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(boolean indAtivo) {
        this.indAtivo = indAtivo;
    }

    @XmlTransient
    public Collection<Filial> getFilialCollection() {
        return filialCollection;
    }

    public void setFilialCollection(Collection<Filial> filialCollection) {
        this.filialCollection = filialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lusano.marcacaodeconsulta.entity.Empresa[ codEmpresa=" + codEmpresa + " ]";
    }
    
}
