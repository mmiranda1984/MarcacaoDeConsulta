/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mmiranda1984
 */
@Entity
@Table(name = "USUARIO", catalog = "MARCACAODECONSULTA", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCodUsuario", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.codUsuario = :codUsuario"),
    @NamedQuery(name = "Usuario.findByCodFilialUsuario", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.codFilialUsuario = :codFilialUsuario"),
    @NamedQuery(name = "Usuario.findByNomUsuario", query = "SELECT u FROM Usuario u WHERE u.nomUsuario = :nomUsuario"),
    @NamedQuery(name = "Usuario.findByTxtLoginUsuario", query = "SELECT u FROM Usuario u WHERE u.txtLoginUsuario = :txtLoginUsuario"),
    @NamedQuery(name = "Usuario.findByTxtSenhaUsuario", query = "SELECT u FROM Usuario u WHERE u.txtSenhaUsuario = :txtSenhaUsuario"),
    @NamedQuery(name = "Usuario.findByIndAtivo", query = "SELECT u FROM Usuario u WHERE u.indAtivo = :indAtivo"),
    @NamedQuery(name = "Usuario.findByFilialLoginAtivo", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.codFilialUsuario = :codFilialUsuario AND u.txtLoginUsuario = :txtLoginUsuario AND u.indAtivo = 1"),
    @NamedQuery(name = "Usuario.findByFilialLoginSenhaAtivo", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.codFilialUsuario = :codFilialUsuario AND u.txtLoginUsuario = :txtLoginUsuario AND u.txtSenhaUsuario = :txtSenhaUsuario AND u.indAtivo = 1")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPK usuarioPK;
    @Basic(optional = false)
    @Column(name = "NOM_USUARIO")
    private String nomUsuario;
    @Basic(optional = false)
    @Column(name = "TXT_LOGIN_USUARIO")
    private String txtLoginUsuario;
    @Basic(optional = false)
    @Column(name = "TXT_SENHA_USUARIO")
    private String txtSenhaUsuario;
    @Basic(optional = false)
    @Column(name = "IND_ATIVO")
    private boolean indAtivo;
    @JoinColumns ({
        @JoinColumn(name="COD_FILIAL_USUARIO", referencedColumnName="COD_FILIAL", insertable = false, updatable = false),
        @JoinColumn(name="COD_FILIAL_USUARIO", referencedColumnName="COD_FILIAL", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Filial filial;

    public Usuario() {
    }

    public Usuario(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public Usuario(UsuarioPK usuarioPK, String nomUsuario, String txtLoginUsuario, String txtSenhaUsuario, boolean indAtivo) {
        this.usuarioPK = usuarioPK;
        this.nomUsuario = nomUsuario;
        this.txtLoginUsuario = txtLoginUsuario;
        this.txtSenhaUsuario = txtSenhaUsuario;
        this.indAtivo = indAtivo;
    }

    public Usuario(int codUsuario, int codFilialUsuario) {
        this.usuarioPK = new UsuarioPK(codUsuario, codFilialUsuario);
    }

    public UsuarioPK getUsuarioPK() {
        return usuarioPK;
    }

    public void setUsuarioPK(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getTxtLoginUsuario() {
        return txtLoginUsuario;
    }

    public void setTxtLoginUsuario(String txtLoginUsuario) {
        this.txtLoginUsuario = txtLoginUsuario;
    }

    public String getTxtSenhaUsuario() {
        return txtSenhaUsuario;
    }

    public void setTxtSenhaUsuario(String txtSenhaUsuario) {
        this.txtSenhaUsuario = txtSenhaUsuario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPK != null ? usuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioPK == null && other.usuarioPK != null) || (this.usuarioPK != null && !this.usuarioPK.equals(other.usuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lusano.marcacaodeconsulta.entity.Usuario[ usuarioPK=" + usuarioPK + " ]";
    }
    
}
