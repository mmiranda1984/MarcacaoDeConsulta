/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import java.util.Date;
import java.util.List;
import lusano.marcacaodeconsulta.entity.Consulta;

/**
 *
 * @author mmiranda1984
 */
public interface RepositorioConsulta {
    
    List<Consulta> obterListaDeConsultasDoPaciente(int codPaciente);
    Consulta obterConsultaDoPacientePorData(int codPaciente, Date dataDaConsulta);
    void salvarConsulta(Consulta consulta);
    void excluirConsulta(Consulta consulta);
    void atualizarConsulta(Consulta consulta);
    void excluirTodasAsConsultasDoPaciente(int codPaciente);
}
