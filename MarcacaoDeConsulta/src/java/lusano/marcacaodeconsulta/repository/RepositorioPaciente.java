/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Paciente;

/**
 *
 * @author mmiranda1984
 */
public interface RepositorioPaciente {
    
    List<Paciente> obterPacientesFilial(int codFilial);
    Paciente obterPacientePorNumeroIdentificacao(String numIdentificacao);
    
    void salvarPaciente(Paciente paciente);
    void excluirPaciente(Paciente paciente);
    void atualizarPaciente(Paciente paciente);
}
