/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import lusano.marcacaodeconsulta.entity.Empresa;

/**
 *
 * @author mmiranda1984
 */
public class RepositorioEmpresaImpl extends RepositorioJPA<Empresa> implements RepositorioEmpresa{
    
    public List<Empresa> obterTodasEmpresasAtivas(){
        try {
            return getEntityManager().createNamedQuery("AnaliseDeCausa.findByIndAtivo", Empresa.class).getResultList();
        } catch (NoResultException ex) {
            return new ArrayList<Empresa>();
        }
    }
    
}
