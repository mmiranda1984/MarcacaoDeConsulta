/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import javax.persistence.EntityManager;
import lusano.marcacaodeconsulta.util.JPAUtil;

/**
 *
 * @author mmiranda1984
 */
public class RepositorioJPA<E> {

    public void persistir(E objeto) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(objeto);
        getEntityManager().flush();
        getEntityManager().getTransaction().commit();
    }

    public void excluir(E objeto) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(objeto);
        getEntityManager().getTransaction().commit();
    }

    public E merge(E objeto) {
        E retorno;
        
        getEntityManager().getTransaction().begin();
        retorno = getEntityManager().merge(objeto);
        getEntityManager().getTransaction().commit();
        
        return retorno;
    }

    public void atualizar (E objeto) {
        getEntityManager().refresh(objeto);
    }

    protected EntityManager getEntityManager() {
        return JPAUtil.getEntityManager();
    }
    
    
}
