/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.service;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Empresa;

/**
 *
 * @author mmiranda1984
 */
public interface ServicoEmpresa {
    
    List<Empresa> obterTodasAsEmpresasAtivas();
    
}
