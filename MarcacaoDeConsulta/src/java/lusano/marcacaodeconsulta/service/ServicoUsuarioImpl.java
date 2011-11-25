/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.service;

import lusano.marcacaodeconsulta.entity.Usuario;
import lusano.marcacaodeconsulta.factory.FabricaRepositorio;
import lusano.marcacaodeconsulta.repository.RepositorioUsuario;
import lusano.marcacaodeconsulta.util.JSFUtil;

/**
 *
 * @author mmiranda1984
 */
public class ServicoUsuarioImpl implements ServicoUsuario{
    
    public Usuario obterUsuarioFilialAtivoPorLoginESenha(int codFilial, String login, String senha){
        RepositorioUsuario rep = FabricaRepositorio.obterRepositorioDeUsuario();
        return rep.obterUsuarioFilialLoginSenha(codFilial, login, senha);
    }
    
    public Usuario obterUsuarioFilialAtivoPorLogin(int codFilial, String login){
        RepositorioUsuario rep = FabricaRepositorio.obterRepositorioDeUsuario();
        return rep.obterUsuarioFilialLogin(codFilial, login);
    }
 
    public Usuario obterUsuarioValidoParaAcessoAoSistema(int codFilial, String login, String senha){
        Usuario usuario = obterUsuarioFilialAtivoPorLogin(codFilial, login);
        if (usuario != null){
            usuario = obterUsuarioFilialAtivoPorLoginESenha(codFilial, login, senha);
            if (usuario != null){
                return usuario;
            } else {
                JSFUtil.informarMensagemDeErro("Senha incorreta");
                return null;
            }
                
        } else {
            JSFUtil.informarMensagemDeErro("Login não cadastrado para a filial selecionada");
            return null;
        }
        
    }
}
