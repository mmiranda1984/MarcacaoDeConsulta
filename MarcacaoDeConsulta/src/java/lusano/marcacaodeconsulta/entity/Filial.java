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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "FILIAL", catalog = "MARCACAODECONSULTA", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filial.findAll", query = "SELECT f FROM Filial f"),
    @NamedQuery(name = "Filial.findByCodFilial", query = "SELECT f FROM Filial f WHERE f.filialPK.codFilial = :codFilial"),
    @NamedQuery(name = "Filial.findByCodEmpresa", query = "SELECT f FROM Filial f WHERE f.filialPK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "Filial.findByNomFilial", query = "SELECT f FROM Filial f WHERE f.nomFilial = :nomFilial"),
    @NamedQuery(name = "Filial.findByTxtEmailFilial", query = "SELECT f FROM Filial f WHERE f.txtEmailFilial = :txtEmailFilial"),
    @NamedQuery(name = "Filial.findByIndAtivo", query = "SELECT f FROM Filial f WHERE f.indAtivo = :indAtivo")})
public class Filial implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FilialPK filialPK;
    @Basic(optional = false)
    @Column(name = "NOM_FILIAL")
    private String nomFilial;
    @Basic(optional = false)
    @Column(name = "TXT_EMAIL_FILIAL")
    private String txtEmailFilial;
    @Basic(optional = false)
    @Column(name = "IND_ATIVO")
    private boolean indAtivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filial")
    private Collection<Paciente> pacienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "filial")
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "COD_EMPRESA", referencedColumnName = "COD_EMPRESA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Filial() {
    }

    public Filial(FilialPK filialPK) {
        this.filialPK = filialPK;
    }

    public Filial(FilialPK filialPK, String nomFilial, String txtEmailFilial, boolean indAtivo) {
        this.filialPK = filialPK;
        this.nomFilial = nomFilial;
        this.txtEmailFilial = txtEmailFilial;
        this.indAtivo = indAtivo;
    }

    public Filial(int codFilial, int codEmpresa) {
        this.filialPK = new FilialPK(codFilial, codEmpresa);
    }

    public FilialPK getFilialPK() {
        return filialPK;
    }

    public void setFilialPK(FilialPK filialPK) {
        this.filialPK = filialPK;
    }

    public String getNomFilial() {
        return nomFilial;
    }

    public void setNomFilial(String nomFilial) {
        this.nomFilial = nomFilial;
    }

    public String getTxtEmailFilial() {
        return txtEmailFilial;
    }

    public void setTxtEmailFilial(String txtEmailFilial) {
        this.txtEmailFilial = txtEmailFilial;
    }

    public boolean getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(boolean indAtivo) {
        this.indAtivo = indAtivo;
    }

    @XmlTransient
    public Collection<Paciente> getPacienteCollection() {
        return pacienteCollection;
    }

    public void setPacienteCollection(Collection<Paciente> pacienteCollection) {
        this.pacienteCollection = pacienteCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filialPK != null ? filialPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filial)) {
            return false;
        }
        Filial other = (Filial) object;
        if ((this.filialPK == null && other.filialPK != null) || (this.filialPK != null && !this.filialPK.equals(other.filialPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lusano.marcacaodeconsulta.entity.Filial[ filialPK=" + filialPK + " ]";
    }
    
}
