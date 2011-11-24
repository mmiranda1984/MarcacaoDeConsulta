/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import lusano.marcacaodeconsulta.entity.Filial;

/**
 *
 * @author mmiranda1984
 */
public class RepositorioFiliaImpl extends RepositorioJPA<Filial> implements RepositorioFilial{
    
    public List<Filial> obterFiliaisAtivasDaEmpresa(int codEmpresa){
        Query query;
        query = getEntityManager().createNamedQuery("Filial.todasAsFiliasAtivasDeUmaEmpresa", Filial.class);
        query.setParameter("codEmpresaFilial", codEmpresa);

        try {
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }

    }
    
}
