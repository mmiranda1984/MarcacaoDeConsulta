/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.service;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Consulta;
import lusano.marcacaodeconsulta.entity.Paciente;

/**
 *
 * @author mmiranda1984
 */
public interface ServicoConsulta {
    
    List<Consulta> obterTodasAsConsultasDoPaciente(int codPaciente);
    void salvarConsulta(Paciente paciente, Consulta consulta);
    void excluirConsulta(Paciente paciente, Consulta consulta);
    void excluirTodasAsConsultasDoPaciente(int codPaciente);
}
