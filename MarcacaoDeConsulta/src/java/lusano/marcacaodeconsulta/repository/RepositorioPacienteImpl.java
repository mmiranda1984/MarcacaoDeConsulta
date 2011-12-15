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
    
    public List<Paciente> obterPacientesFilialDeAcordoComOFiltro(String identificacaoBusca, String nomeBusca, String emailBusca, int ativoBusca, int codFilial){
        Query query;
        query = getEntityManager().createNamedQuery("Paciente.obterPacientesDeAcordoComOFiltro", Paciente.class);
        if (!identificacaoBusca.equals(""))
            query.setParameter("numIdentificacaoPaciente", identificacaoBusca);
        else
            query.setParameter("numIdentificacaoPaciente", null);
        
        if (!nomeBusca.equals(""))
            query.setParameter("nomPaciente", "%"+nomeBusca+"%");
        else
            query.setParameter("nomPaciente", null);
        
        if (!emailBusca.equals(""))
            query.setParameter("txtEmailPaciente", "%"+emailBusca+"%");
        else
            query.setParameter("txtEmailPaciente", null);
        
        if (ativoBusca == -1)
            query.setParameter("indAtivo", null);
        else if (ativoBusca == 0)
            query.setParameter("indAtivo", false);
        else
            query.setParameter("indAtivo", true);

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
