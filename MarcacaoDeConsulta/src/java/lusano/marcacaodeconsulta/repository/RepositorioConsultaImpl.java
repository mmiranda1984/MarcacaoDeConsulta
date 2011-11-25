/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import lusano.marcacaodeconsulta.entity.Consulta;

/**
 *
 * @author mmiranda1984
 */
public class RepositorioConsultaImpl extends RepositorioJPA<Consulta> implements RepositorioConsulta{
    
    public List<Consulta> obterListaDeConsultasDoPaciente(int codPaciente){
        Query query;
        query = getEntityManager().createNamedQuery("Consulta.findByCodPacienteConsulta", Consulta.class);
        query.setParameter("codPacienteConsulta", codPaciente);

        try {
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public void salvarConsulta(Consulta consulta){
        if (consulta.getConsultaPK().getCodConsulta() != 0)
            merge(consulta);
        else
            persistir(consulta);
    }

    public void excluirConsulta(Consulta consulta){
        excluir(consulta);
    }
    
    public void excluirTodasAsConsultasDoPaciente(int codPaciente){
        Query query;
        query = getEntityManager().createNamedQuery("Consulta.removeByCodPacienteConsulta", Consulta.class);
        query.setParameter("codPacienteConsulta", codPaciente);

        query.executeUpdate();
    }
    
    public Consulta obterConsultaDoPacientePorData(int codPaciente, Date dataDaConsulta){
        Query query;
        query = getEntityManager().createNamedQuery("Consulta.findByPacienteDatConsulta", Consulta.class);
        query.setParameter("codPacienteConsulta", codPaciente);
        query.setParameter("datConsulta", dataDaConsulta);

        try {
            return (Consulta) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    public void atualizarConsulta(Consulta consulta){
        atualizar(consulta);
    }
}
