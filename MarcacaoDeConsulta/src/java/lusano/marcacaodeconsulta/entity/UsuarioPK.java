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
    @Column(name = "COD_FILIAL_USUARIO")
    private int codFilialUsuario;

    public UsuarioPK() {
    }

    public UsuarioPK(int codUsuario, int codFilialUsuario) {
        this.codUsuario = codUsuario;
        this.codFilialUsuario = codFilialUsuario;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getCodFilialUsuario() {
        return codFilialUsuario;
    }

    public void setCodFilialUsuario(int codFilialUsuario) {
        this.codFilialUsuario = codFilialUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codUsuario;
        hash += (int) codFilialUsuario;
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
        if (this.codFilialUsuario != other.codFilialUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lusano.marcacaodeconsulta.entity.UsuarioPK[ codUsuario=" + codUsuario + ", codFilialUsuario=" + codFilialUsuario + " ]";
    }
    
}
