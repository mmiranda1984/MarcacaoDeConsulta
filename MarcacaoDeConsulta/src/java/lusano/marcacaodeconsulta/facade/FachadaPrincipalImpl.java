/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.facade;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Paciente;
import lusano.marcacaodeconsulta.factory.FabricaServico;
import lusano.marcacaodeconsulta.service.ServicoPaciente;

/**
 *
 * @author mmiranda1984
 */
public class FachadaPrincipalImpl implements FachadaPrincipal{
    
    public List<Paciente> obterTodosOsPacientesDaFilial(int codFilial){
        ServicoPaciente servico = FabricaServico.obterServicoDePaciente();
        return servico.obterTodosOsPacientesDaFilial(codFilial);
    }
    
}
