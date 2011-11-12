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
public class FilialPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_FILIAL")
    private int codFilial;
    @Basic(optional = false)
    @Column(name = "COD_EMPRESA")
    private int codEmpresa;

    public FilialPK() {
    }

    public FilialPK(int codFilial, int codEmpresa) {
        this.codFilial = codFilial;
        this.codEmpresa = codEmpresa;
    }

    public int getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }

    public int getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(int codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codFilial;
        hash += (int) codEmpresa;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilialPK)) {
            return false;
        }
        FilialPK other = (FilialPK) object;
        if (this.codFilial != other.codFilial) {
            return false;
        }
        if (this.codEmpresa != other.codEmpresa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lusano.marcacaodeconsulta.entity.FilialPK[ codFilial=" + codFilial + ", codEmpresa=" + codEmpresa + " ]";
    }
    
}
