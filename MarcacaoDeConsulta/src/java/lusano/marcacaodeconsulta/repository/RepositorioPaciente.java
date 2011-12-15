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
    List<Paciente> obterPacientesFilialDeAcordoComOFiltro(String identificacaoBusca, String nomeBusca, String emailBusca, int ativoBusca, int codFilial);
    Paciente obterPacienteFilialPorNumeroIdentificacao(int codFilial, String numIdentificacao);
    
    void salvarPaciente(Paciente paciente);
    void excluirPaciente(Paciente paciente);
    void atualizarPaciente(Paciente paciente);
}
