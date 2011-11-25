/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.factory;

import lusano.marcacaodeconsulta.service.ServicoConsulta;
import lusano.marcacaodeconsulta.service.ServicoConsultaImpl;
import lusano.marcacaodeconsulta.service.ServicoEmpresa;
import lusano.marcacaodeconsulta.service.ServicoEmpresaImpl;
import lusano.marcacaodeconsulta.service.ServicoFilial;
import lusano.marcacaodeconsulta.service.ServicoFilialImpl;
import lusano.marcacaodeconsulta.service.ServicoPaciente;
import lusano.marcacaodeconsulta.service.ServicoPacienteImpl;
import lusano.marcacaodeconsulta.service.ServicoUsuario;
import lusano.marcacaodeconsulta.service.ServicoUsuarioImpl;

/**
 *
 * @author mmiranda1984
 */
public class FabricaServico {

    public static ServicoEmpresa obterServicoDeEmpresa(){
        return new ServicoEmpresaImpl();
    }

    public static ServicoFilial obterServicoDeFilial(){
        return new ServicoFilialImpl();
    }

    public static ServicoUsuario obterServicoDeUsuario(){
        return new ServicoUsuarioImpl();
    }
    
    public static ServicoPaciente obterServicoDePaciente(){
        return new ServicoPacienteImpl();
    }
    
    public static ServicoConsulta obterServicoDeConsulta(){
        return new ServicoConsultaImpl();
    }
    
    
}
