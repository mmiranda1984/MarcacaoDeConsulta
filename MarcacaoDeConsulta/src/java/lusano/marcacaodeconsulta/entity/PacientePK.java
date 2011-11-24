/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author mmiranda1984
 */
@Embeddable
public class PacientePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_PACIENTE")
    private int codPaciente;
    @Basic(optional = false)
    @Column(name = "COD_FILIAL_PACIENTE")
    private int codFilialPaciente;

    public PacientePK() {
    }

    public PacientePK(int codPaciente, int codFilialPaciente) {
        this.codPaciente = codPaciente;
        this.codFilialPaciente = codFilialPaciente;
    }

    public int getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(int codPaciente) {
        this.codPaciente = codPaciente;
    }

    public int getCodFilialPaciente() {
        return codFilialPaciente;
    }

    public void setCodFilialPaciente(int codFilialPaciente) {
        this.codFilialPaciente = codFilialPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPaciente;
        hash += (int) codFilialPaciente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PacientePK)) {
            return false;
        }
        PacientePK other = (PacientePK) object;
        if (this.codPaciente != other.codPaciente) {
            return false;
        }
        if (this.codFilialPaciente != other.codFilialPaciente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lusano.marcacaodeconsulta.entity.PacientePK[ codPaciente=" + codPaciente + ", codFilialPaciente=" + codFilialPaciente + " ]";
    }
    
}
