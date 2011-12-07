/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import lusano.marcacaodeconsulta.entity.Paciente;

/**
 *
 * @author mmiranda1984
 */
public class RepositorioPacienteImpl extends RepositorioJPA<Paciente> implements RepositorioPaciente{
    
    public List<Paciente> obterPacientesFilial(int codFilial){
        Query query;
        query = getEntityManager().createNamedQuery("Paciente.findByCodFilialPaciente", Paciente.class);
        query.setParameter("codFilialPaciente", codFilial);

        try {
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public Paciente obterPacienteFilialPorNumeroIdentificacao(int codFilial, String numIdentificacao){
        Query query;
        query = getEntityManager().createNamedQuery("Paciente.findByNumIdentificacaoPacienteFilial", Paciente.class);
        query.setParameter("numIdentificacaoPaciente", numIdentificacao);
        query.setParameter("codFilialPaciente", codFilial);

        try {
            return (Paciente) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public void salvarPaciente(Paciente paciente){
        if (paciente.getPacientePK().getCodPaciente() != 0)
            merge(paciente);
        else
            persistir(paciente);
    }

    public void excluirPaciente(Paciente paciente){
        excluir(paciente);
    }
    
    public void atualizarPaciente(Paciente paciente){
        atualizar(paciente);
    }
}
