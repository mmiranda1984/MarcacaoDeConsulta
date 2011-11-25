/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.service;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Paciente;
import lusano.marcacaodeconsulta.factory.FabricaRepositorio;
import lusano.marcacaodeconsulta.repository.RepositorioPaciente;
import lusano.marcacaodeconsulta.util.JSFUtil;

/**
 *
 * @author mmiranda1984
 */
public class ServicoPacienteImpl implements ServicoPaciente{

    public List<Paciente> obterTodosOsPacientesDaFilial(int codFilial){
        RepositorioPaciente rep = FabricaRepositorio.obterRepositorioDePaciente();
        return rep.obterPacientesFilial(codFilial);
    }
    
    public void salvarPaciente(Paciente paciente){
        RepositorioPaciente rep = FabricaRepositorio.obterRepositorioDePaciente();
        
        if (paciente.getNumIdentificacaoPaciente() != "") {
            Paciente pacienteComparacao = rep.obterPacientePorNumeroIdentificacao(paciente.getNumIdentificacaoPaciente());

            if ((pacienteComparacao != null) &&
                    (!pacienteComparacao.getPacientePK().equals(paciente.getPacientePK()))){
                JSFUtil.informarMensagemDeErro("O número de indentificação informado já está cadastrado");
                rep.atualizarPaciente(paciente);
            } else {
                rep.salvarPaciente(paciente);
            }
        } else {
            rep.salvarPaciente(paciente);
        }
    }

    public void excluirPaciente(Paciente paciente){
        RepositorioPaciente rep = FabricaRepositorio.obterRepositorioDePaciente();
        if (!paciente.getConsultaCollection().isEmpty()){
            JSFUtil.informarMensagemDeErro("Não é possível excluir um paciente que contém consulta(s) cadastrada(s)");
        } else {
            rep.excluirPaciente(paciente);
        }
    }
    
    public Paciente obterPacientePorNumeroIdentificacao(String numIdentificacao){
        RepositorioPaciente rep = FabricaRepositorio.obterRepositorioDePaciente();
        return rep.obterPacientePorNumeroIdentificacao(numIdentificacao);
    }
}
