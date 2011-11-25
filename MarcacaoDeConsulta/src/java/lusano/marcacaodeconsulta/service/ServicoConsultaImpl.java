/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.service;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Consulta;
import lusano.marcacaodeconsulta.entity.Paciente;
import lusano.marcacaodeconsulta.factory.FabricaRepositorio;
import lusano.marcacaodeconsulta.repository.RepositorioConsulta;
import lusano.marcacaodeconsulta.util.JSFUtil;

/**
 *
 * @author mmiranda1984
 */
public class ServicoConsultaImpl implements ServicoConsulta{

    public List<Consulta> obterTodasAsConsultasDoPaciente(int codPaciente){
        RepositorioConsulta rep = FabricaRepositorio.obterRepositorioDeConsulta();
        return rep.obterListaDeConsultasDoPaciente(codPaciente);
    }
    
    public void salvarConsulta(Paciente paciente, Consulta consulta){
        RepositorioConsulta rep = FabricaRepositorio.obterRepositorioDeConsulta();
        Consulta consultaComparacao = rep.obterConsultaDoPacientePorData(paciente.getPacientePK().getCodPaciente(), consulta.getDatConsulta());
        if (consultaComparacao != null){
            JSFUtil.informarMensagemDeErro("Já existe uma consulta cadastrada nesta data para esse paciente");
        } else {
            rep.salvarConsulta(consulta);
        }
    }

    public void excluirConsulta(Paciente paciente, Consulta consulta){
        RepositorioConsulta rep = FabricaRepositorio.obterRepositorioDeConsulta();
        rep.excluirConsulta(consulta);
    }
    
    public void excluirTodasAsConsultasDoPaciente(int codPaciente){
        RepositorioConsulta rep = FabricaRepositorio.obterRepositorioDeConsulta();
        rep.excluirTodasAsConsultasDoPaciente(codPaciente);
    }
    
}
