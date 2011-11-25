/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.facade;

import java.util.List;
import lusano.marcacaodeconsulta.entity.Paciente;

/**
 *
 * @author mmiranda1984
 */
public interface FachadaPrincipal {
    
    List<Paciente> obterTodosOsPacientesDaFilial(int codFilial);
    
}
