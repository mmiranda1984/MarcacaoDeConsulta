/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.factory;

import lusano.marcacaodeconsulta.repository.RepositorioEmpresa;
import lusano.marcacaodeconsulta.repository.RepositorioEmpresaImpl;
import lusano.marcacaodeconsulta.repository.RepositorioFiliaImpl;
import lusano.marcacaodeconsulta.repository.RepositorioFilial;

/**
 *
 * @author mmiranda1984
 */
public class FabricaRepositorio {

    public static RepositorioEmpresa obterRepositorioDeEmpresa(){
        return new RepositorioEmpresaImpl();
    }

    public static RepositorioFilial obterRepositorioDeFilial(){
        return new RepositorioFiliaImpl();
    }
}
