/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import lusano.marcacaodeconsulta.entity.Usuario;

/**
 *
 * @author mmiranda1984
 */
public class RepositorioUsuarioImpl extends RepositorioJPA<Usuario> implements RepositorioUsuario{
    
    public Usuario obterUsuarioFilialLoginSenha(int codFilial, String login, String senha){

        Query query;
        query = getEntityManager().createNamedQuery("Usuario.findByFilialLoginSenhaAtivo", Usuario.class);
        query.setParameter("codFilialUsuario", codFilial);
        query.setParameter("txtLoginUsuario", login);
        query.setParameter("txtSenhaUsuario", senha);

        try {
            return (Usuario) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public Usuario obterUsuarioFilialLogin(int codFilial, String login){

        Query query;
        query = getEntityManager().createNamedQuery("Usuario.findByFilialLoginAtivo", Usuario.class);
        query.setParameter("codFilialUsuario", codFilial);
        query.setParameter("txtLoginUsuario", login);

        try {
            return (Usuario) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
 
    public void salvarUsuario(Usuario usuario){
        if (usuario.getUsuarioPK().getCodUsuario() > 0)
            merge(usuario);
    }
}
