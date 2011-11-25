/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import lusano.marcacaodeconsulta.entity.Usuario;

/**
 *
 * @author mmiranda1984
 */
public interface RepositorioUsuario {
    
    Usuario obterUsuarioFilialLoginSenha(int codFilial, String login, String senha);
    Usuario obterUsuarioFilialLogin(int codFilial, String login);
    
}
