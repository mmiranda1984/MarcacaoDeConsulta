/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import lusano.marcacaodeconsulta.entity.Filial;

/**
 *
 * @author mmiranda1984
 */
public class RepositorioFiliaImpl extends RepositorioJPA<Filial> implements RepositorioFilial{
    
    public List<Filial> obterFiliaisEmpresa(int codEmpresa){
        try {
            return getEntityManager().createNamedQuery("Filial.findByCodEmpresa", Filial.class).getResultList();
        } catch (NoResultException ex) {
            return new ArrayList<Filial>();
        }
    }
    
}
