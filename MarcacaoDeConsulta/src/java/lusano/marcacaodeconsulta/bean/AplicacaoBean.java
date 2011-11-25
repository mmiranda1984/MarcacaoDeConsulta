/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lusano.marcacaodeconsulta.valueobject.Versao;

/**
 *
 * @author mmiranda1984
 */
@ManagedBean
@ViewScoped
public class AplicacaoBean implements Serializable{
    
    public AplicacaoBean(){
        
    }
    
    public String getVersaoSistema(){
        return Versao.obterVersaoDoSistema();
    }
}
