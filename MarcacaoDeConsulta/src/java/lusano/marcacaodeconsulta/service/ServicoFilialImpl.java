/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.service;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Filial;
import lusano.marcacaodeconsulta.factory.FabricaRepositorio;
import lusano.marcacaodeconsulta.repository.RepositorioFilial;

/**
 *
 * @author mmiranda1984
 */
public class ServicoFilialImpl implements ServicoFilial{
    
    public List<Filial> obterFiliaisAtivasDaEmpresa(int codEmpresa){
        RepositorioFilial rep = FabricaRepositorio.obterRepositorioDeFilial();
        return rep.obterFiliaisAtivasDaEmpresa(codEmpresa);
    }
    
}
