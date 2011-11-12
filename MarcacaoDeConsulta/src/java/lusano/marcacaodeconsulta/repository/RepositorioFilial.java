/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Filial;

/**
 *
 * @author mmiranda1984
 */
public interface RepositorioFilial {
    
    List<Filial> obterFiliaisEmpresa(int codEmpresa);
    
}
