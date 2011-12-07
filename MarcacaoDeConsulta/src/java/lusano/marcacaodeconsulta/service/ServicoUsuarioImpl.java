/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import lusano.criptografiadesenha.util.CriptografiaSenha;
import lusano.marcacaodeconsulta.entity.Usuario;
import lusano.marcacaodeconsulta.factory.FabricaRepositorio;
import lusano.marcacaodeconsulta.repository.RepositorioUsuario;
import lusano.marcacaodeconsulta.util.ConstantsUtil;
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
    
    public void AlterarSenha(String novaSenha, String novaSenhaConfirmacao){
        if (novaSenha.equals(novaSenhaConfirmacao)){
            Usuario usuario = (Usuario) JSFUtil.obterObjetoNaSessao("usuario");
            usuario.setTxtSenhaUsuario(novaSenha);
            
            RepositorioUsuario rep = FabricaRepositorio.obterRepositorioDeUsuario();
            
            rep.salvarUsuario(usuario);
            JSFUtil.informarMensagemDeInformacao("A senha foi alterada com sucesso", false);
        } else {
            JSFUtil.informarMensagemDeErro("A nova senha e a confirmação da nova senha, não conferem");
        }
        
    }
    
    public void gerarNovaSenhaEEnviarPorEmail(int codFilial, String login){
        if ((codFilial > 0) & (!login.equals(""))) {
            Usuario usuario = obterUsuarioFilialAtivoPorLogin(codFilial, login);
            if (usuario != null){
                String novaSenha = CriptografiaSenha.obterNovaSenhaCriptografada();
                try {
                    String novaSenhaCriptografada = CriptografiaSenha.criptografarSenha(novaSenha);
                    String corpoMensagem = ConstantsUtil.getCorpoEmailAlterarSenha().replace("<nomeusuario>", usuario.getNomUsuario());
                    corpoMensagem = corpoMensagem.replace("<novasenha>", novaSenha);

                    if (JSFUtil.enviarEmail(usuario, ConstantsUtil.getTituloEmailAlterarSenha(), corpoMensagem, "")) {
                        RepositorioUsuario rep = FabricaRepositorio.obterRepositorioDeUsuario();
                        usuario.setTxtSenhaUsuario(novaSenhaCriptografada);
                        rep.salvarUsuario(usuario);
                           
                        JSFUtil.informarMensagemDeAlerta("A nova senha foi enviada por e-mail");
                    } else {
                        JSFUtil.informarMensagemDeErro("Erro ao gerar e enviar a nova senha");
                    }
                } catch (Exception ex) {
                    JSFUtil.informarMensagemDeErro(ex.getMessage());
                }
            } else {
                JSFUtil.informarMensagemDeErro("Login não cadastrado para a filial selecionada");
            }
        } else {
            JSFUtil.informarMensagemDeErro("Selecione uma filial e digite o login do usuário que deseja recuperar a senha");
        }
    }
}
