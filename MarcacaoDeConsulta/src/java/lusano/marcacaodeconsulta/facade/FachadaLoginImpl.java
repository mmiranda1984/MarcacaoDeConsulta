/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.facade;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Empresa;
import lusano.marcacaodeconsulta.entity.Filial;
import lusano.marcacaodeconsulta.entity.Usuario;
import lusano.marcacaodeconsulta.factory.FabricaServico;
import lusano.marcacaodeconsulta.service.ServicoEmpresa;
import lusano.marcacaodeconsulta.service.ServicoFilial;
import lusano.marcacaodeconsulta.service.ServicoUsuario;

/**
 *
 * @author mmiranda1984
 */
public class FachadaLoginImpl implements FachadaLogin {
    
    public List<Empresa> obterTodasAsEmpresasAtivas(){
        ServicoEmpresa servico = FabricaServico.obterServicoDeEmpresa();
        return servico.obterTodasAsEmpresasAtivas();
    }
    

    public List<Filial> obterFiliaisAtivasDaEmpresa(int codEmpresa){
        ServicoFilial servico = FabricaServico.obterServicoDeFilial();
        return servico.obterFiliaisAtivasDaEmpresa(codEmpresa);
    }
    
    public Usuario obterUsuarioFilialAtivoPorLoginESenha(int codFilial, String login, String senha){
        ServicoUsuario servico = FabricaServico.obterServicoDeUsuario();
        return servico.obterUsuarioFilialAtivoPorLoginESenha(codFilial, login, senha);
    }

    public Usuario obterUsuarioFilialAtivoPorLogin(int codFilial, String login){
        ServicoUsuario servico = FabricaServico.obterServicoDeUsuario();
        return servico.obterUsuarioFilialAtivoPorLogin(codFilial, login);
    }
}
