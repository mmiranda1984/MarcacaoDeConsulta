/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.service;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Paciente;

/**
 *
 * @author mmiranda1984
 */
public interface ServicoPaciente {
 
    List<Paciente> obterTodosOsPacientesDaFilial(int codFilial);
    Paciente obterPacientePorNumeroIdentificacao(String numIdentificacao);
    
    void salvarPaciente(Paciente paciente);
    void excluirPaciente(Paciente paciente);
    
}