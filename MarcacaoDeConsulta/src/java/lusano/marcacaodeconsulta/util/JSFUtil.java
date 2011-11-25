/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.util;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lusano.marcacaodeconsulta.valueobject.MensagemRetorno;
import lusano.marcacaodeconsulta.valueobject.TipoMensagemRetorno;
import org.primefaces.context.RequestContext;

/**
 *
 * @author mmiranda1984
 */
public class JSFUtil {
    
    public static void informarMensagem(MensagemRetorno mensagem) {

        if (mensagem.getTipo() == TipoMensagemRetorno.MSG_ALERTA)
            informarMensagemDeAlerta(mensagem.getMensagem());

        if (mensagem.getTipo() == TipoMensagemRetorno.MSG_ERRO)
            informarMensagemDeErro(mensagem.getMensagem());

        if (mensagem.getTipo() == TipoMensagemRetorno.MSG_INFORMACAO)
            informarMensagemDeInformacao(mensagem.getMensagem(), !mensagem.getFechaDialogo());

    }

    public static void informarMensagemDeErro(String mensagem) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null);
        FacesContext.getCurrentInstance().addMessage("", fm);

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.addCallbackParam("msgErro", true);
    }

    public static void informarMensagemDeInformacao(String mensagem, Boolean travarTela) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null);
        FacesContext.getCurrentInstance().addMessage("", fm);

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.addCallbackParam("msgErro", travarTela);
    }

    public static void informarMensagemDeAlerta(String mensagem) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null);
        FacesContext.getCurrentInstance().addMessage("", fm);

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.addCallbackParam("msgErro", true);
    }
    
    public static void adicionarObjetoNaSessao(String chave, Object objeto) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(chave, objeto);
    }

    public static Object obterObjetoNaSessao(String chave) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        return session.getAttribute(chave);
    }

    public static void redirecionarParaAPagina(String pagina){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/MarcacaoDeConsulta/faces/"+pagina);
        } catch (IOException ex) {
            Logger.getLogger(JSFUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void removerObjetoDaSessao(String chave){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        session.removeAttribute(chave);
    }
}
