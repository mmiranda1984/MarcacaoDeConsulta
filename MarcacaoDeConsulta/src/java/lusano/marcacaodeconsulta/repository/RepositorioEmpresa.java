/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Empresa;

/**
 *
 * @author mmiranda1984
 */
public interface RepositorioEmpresa {
    
    List<Empresa> obterTodasEmpresasAtivas();
    
}
