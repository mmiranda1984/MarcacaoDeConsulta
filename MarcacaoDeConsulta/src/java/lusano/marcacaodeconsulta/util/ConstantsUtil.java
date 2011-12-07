/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.util;

/**
 *
 * @author mmiranda1984
 */
public class ConstantsUtil {

    private static final String corpoEmailAlterarSenha = 
            "<html><body>Prezado(a) <b><nomeusuario></b>, <br/><br/>" +
            "	De acordo com sua solicitação no site www.marcacaodeconsultas.com.br, segue abaixo a sua nova senha: <br/><br/>"+
            "   <b><novasenha></b> <br/><br/>"+
            "Esse é apenas um e-mail informativo, favor não respondê-lo. <br/><br/>"+
            "Atenciosamente, <br/>"+
            "Marcação de Consultas <br/>"+
            "www.marcacaodeconsultas.com.br</body></html>";
    private static final String tituloEmailAlterarSenha = 
            "Marcação de Consultas - Envio de nova senha!!!";

    /**
     * @return the corpoEmailAlterarSenha
     */
    public static String getCorpoEmailAlterarSenha() {
        return corpoEmailAlterarSenha;
    }

    /**
     * @return the tituloEmailAlterarSenha
     */
    public static String getTituloEmailAlterarSenha() {
        return tituloEmailAlterarSenha;
    }
    
    
}
