/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import lusano.marcacaodeconsulta.entity.Empresa;

/**
 *
 * @author mmiranda1984
 */
public class RepositorioEmpresaImpl extends RepositorioJPA<Empresa> implements RepositorioEmpresa{
    
    public List<Empresa> obterTodasEmpresasAtivas(){
        Query query;
        query = getEntityManager().createNamedQuery("Empresa.findByIndAtivo", Empresa.class);
        query.setParameter("indAtivo", true);

        try {
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
