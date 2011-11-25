/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.valueobject;

import javax.faces.context.FacesContext;

/**
 *
 * @author mmiranda1984
 */
public class Versao {

    public static String obterVersaoDoSistema() {
        String param = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("versao");
        return param;
    }    
    
}
