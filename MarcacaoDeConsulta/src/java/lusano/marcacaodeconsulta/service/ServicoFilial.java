/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.service;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Filial;

/**
 *
 * @author mmiranda1984
 */
public interface ServicoFilial {
    
    List<Filial> obterFiliaisAtivasDaEmpresa(int codEmpresa);
    
}
