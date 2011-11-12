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
public class UsuarioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "COD_USUARIO")
    private int codUsuario;
    @Basic(optional = false)
    @Column(name = "COD_FILIAL")
    private int codFilial;

    public UsuarioPK() {
    }

    public UsuarioPK(int codUsuario, int codFilial) {
        this.codUsuario = codUsuario;
        this.codFilial = codFilial;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codUsuario;
        hash += (int) codFilial;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPK)) {
            return false;
        }
        UsuarioPK other = (UsuarioPK) object;
        if (this.codUsuario != other.codUsuario) {
            return false;
        }
        if (this.codFilial != other.codFilial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lusano.marcacaodeconsulta.entity.UsuarioPK[ codUsuario=" + codUsuario + ", codFilial=" + codFilial + " ]";
    }
    
}
