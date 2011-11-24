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
public class ConsultaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_CONSULTA")
    private int codConsulta;
    @Basic(optional = false)
    @Column(name = "COD_PACIENTE_CONSULTA")
    private int codPacienteConsulta;

    public ConsultaPK() {
    }

    public ConsultaPK(int codConsulta, int codPacienteConsulta) {
        this.codConsulta = codConsulta;
        this.codPacienteConsulta = codPacienteConsulta;
    }

    public int getCodConsulta() {
        return codConsulta;
    }

    public void setCodConsulta(int codConsulta) {
        this.codConsulta = codConsulta;
    }

    public int getCodPacienteConsulta() {
        return codPacienteConsulta;
    }

    public void setCodPacienteConsulta(int codPacienteConsulta) {
        this.codPacienteConsulta = codPacienteConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codConsulta;
        hash += (int) codPacienteConsulta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultaPK)) {
            return false;
        }
        ConsultaPK other = (ConsultaPK) object;
        if (this.codConsulta != other.codConsulta) {
            return false;
        }
        if (this.codPacienteConsulta != other.codPacienteConsulta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lusano.marcacaodeconsulta.entity.ConsultaPK[ codConsulta=" + codConsulta + ", codPacienteConsulta=" + codPacienteConsulta + " ]";
    }
    
}
