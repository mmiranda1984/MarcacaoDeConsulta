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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mmiranda1984
 */
@Entity
@Table(name = "PACIENTE", catalog = "MARCACAODECONSULTA", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByCodPaciente", query = "SELECT p FROM Paciente p WHERE p.pacientePK.codPaciente = :codPaciente"),
    @NamedQuery(name = "Paciente.findByCodFilialPaciente", query = "SELECT p FROM Paciente p WHERE p.pacientePK.codFilialPaciente = :codFilialPaciente"),
    @NamedQuery(name = "Paciente.findByNumIdentificacaoPacienteFilial", query = "SELECT p FROM Paciente p WHERE p.numIdentificacaoPaciente = :numIdentificacaoPaciente AND p.pacientePK.codFilialPaciente = :codFilialPaciente"),
    @NamedQuery(name = "Paciente.findByNomPaciente", query = "SELECT p FROM Paciente p WHERE p.nomPaciente = :nomPaciente"),
    @NamedQuery(name = "Paciente.findByTxtEmailPaciente", query = "SELECT p FROM Paciente p WHERE p.txtEmailPaciente = :txtEmailPaciente"),
    @NamedQuery(name = "Paciente.findByNumContatoPaciente", query = "SELECT p FROM Paciente p WHERE p.numContatoPaciente = :numContatoPaciente"),
    @NamedQuery(name = "Paciente.findByIndAtivoCodFilial", query = "SELECT p FROM Paciente p WHERE p.pacientePK.codFilialPaciente = :codFilialPaciente AND p.indAtivo = :indAtivo"),
    @NamedQuery(name = "Paciente.findByIndAtivo", query = "SELECT p FROM Paciente p WHERE p.indAtivo = :indAtivo")})
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PacientePK pacientePK;
    @Column(name = "NUM_IDENTIFICACAO_PACIENTE")
    private String numIdentificacaoPaciente;
    @Column(name = "NOM_PACIENTE")
    private String nomPaciente;
    @Column(name = "TXT_EMAIL_PACIENTE")
    private String txtEmailPaciente;
    @Column(name = "NUM_CONTATO_PACIENTE")
    private String numContatoPaciente;
    @Basic(optional = false)
    @Column(name = "IND_ATIVO")
    private boolean indAtivo;
    @ManyToOne(optional = false)
    @JoinColumns ({
        @JoinColumn(name="COD_FILIAL_PACIENTE", referencedColumnName="COD_FILIAL", insertable = false, updatable = false),
        @JoinColumn(name="COD_FILIAL_PACIENTE", referencedColumnName="COD_FILIAL", insertable = false, updatable = false)
    })
    private Filial filial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<Consulta> consultaCollection;
    @Transient
    private String status;

    public Paciente() {
    }

    public Paciente(PacientePK pacientePK) {
        this.pacientePK = pacientePK;
    }

    public Paciente(PacientePK pacientePK, boolean indAtivo) {
        this.pacientePK = pacientePK;
        this.indAtivo = indAtivo;
    }

    public Paciente(int codPaciente, int codFilialPaciente) {
        this.pacientePK = new PacientePK(codPaciente, codFilialPaciente);
    }

    public PacientePK getPacientePK() {
        return pacientePK;
    }

    public void setPacientePK(PacientePK pacientePK) {
        this.pacientePK = pacientePK;
    }

    public String getNumIdentificacaoPaciente() {
        return numIdentificacaoPaciente;
    }

    public void setNumIdentificacaoPaciente(String numIdentificacaoPaciente) {
        this.numIdentificacaoPaciente = numIdentificacaoPaciente;
    }

    public String getNomPaciente() {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }

    public String getTxtEmailPaciente() {
        return txtEmailPaciente;
    }

    public void setTxtEmailPaciente(String txtEmailPaciente) {
        this.txtEmailPaciente = txtEmailPaciente;
    }

    public String getNumContatoPaciente() {
        return numContatoPaciente;
    }

    public void setNumContatoPaciente(String numContatoPaciente) {
        this.numContatoPaciente = numContatoPaciente;
    }

    public boolean getIndAtivo() {
        return indAtivo;
    }

    public void setIndAtivo(boolean indAtivo) {
        this.indAtivo = indAtivo;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    @XmlTransient
    public Collection<Consulta> getConsultaCollection() {
        return consultaCollection;
    }

    public void setConsultaCollection(Collection<Consulta> consultaCollection) {
        this.consultaCollection = consultaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacientePK != null ? pacientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.pacientePK == null && other.pacientePK != null) || (this.pacientePK != null && !this.pacientePK.equals(other.pacientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lusano.marcacaodeconsulta.entity.Paciente[ pacientePK=" + pacientePK + " ]";
    }

    /**
     * @return the ativo
     */
    public String getStatus() {
        if (getIndAtivo()) 
            return "Ativo";
        else
            return "Inativo";
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
}
