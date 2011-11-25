/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.factory;

import lusano.marcacaodeconsulta.facade.FachadaLogin;
import lusano.marcacaodeconsulta.facade.FachadaLoginImpl;
import lusano.marcacaodeconsulta.facade.FachadaPrincipal;
import lusano.marcacaodeconsulta.facade.FachadaPrincipalImpl;

/**
 *
 * @author mmiranda1984
 */
public class FabricaFachada {

    public static FachadaLogin obterFachadaDeLogin(){
        return new FachadaLoginImpl();
    }
    
    public static FachadaPrincipal obterFachadaDoPrincipal(){
        return new FachadaPrincipalImpl();
    }
    
    
}
