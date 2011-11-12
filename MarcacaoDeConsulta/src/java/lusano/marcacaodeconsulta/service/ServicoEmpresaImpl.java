/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.service;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Empresa;
import lusano.marcacaodeconsulta.factory.FabricaRepositorio;
import lusano.marcacaodeconsulta.repository.RepositorioEmpresa;

/**
 *
 * @author mmiranda1984
 */
public class ServicoEmpresaImpl implements ServicoEmpresa{
    
    public List<Empresa> obterTodasAsEmpresasAtivas(){
        RepositorioEmpresa rep = FabricaRepositorio.obterRepositorioDeEmpresa();
        return rep.obterTodasEmpresasAtivas();
    }
    
}
