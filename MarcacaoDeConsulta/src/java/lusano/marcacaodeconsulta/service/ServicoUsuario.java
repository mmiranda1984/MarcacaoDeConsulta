/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.service;

import lusano.marcacaodeconsulta.entity.Usuario;

/**
 *
 * @author mmiranda1984
 */
public interface ServicoUsuario {
    
    Usuario obterUsuarioFilialAtivoPorLoginESenha(int codFilial, String login, String senha);
    Usuario obterUsuarioFilialAtivoPorLogin(int codFilial, String login);
    
    Usuario obterUsuarioValidoParaAcessoAoSistema(int codFilial, String login, String senha);
}
