/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.facade;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Empresa;
import lusano.marcacaodeconsulta.entity.Filial;
import lusano.marcacaodeconsulta.entity.Usuario;

/**
 *
 * @author mmiranda1984
 */
public interface FachadaLogin {
    
    List<Empresa> obterTodasAsEmpresasAtivas();
    List<Filial> obterFiliaisAtivasDaEmpresa(int codEmpresa);
    Usuario obterUsuarioFilialAtivoPorLoginESenha(int codFilial, String login, String senha);
    Usuario obterUsuarioFilialAtivoPorLogin(int codFilial, String login);

}
