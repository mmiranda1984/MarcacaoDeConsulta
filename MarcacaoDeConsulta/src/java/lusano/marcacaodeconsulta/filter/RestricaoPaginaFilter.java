/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lusano.marcacaodeconsulta.util.JSFUtil;

/**
 *
 * @author mmiranda1984
 */
public class RestricaoPaginaFilter implements Filter{

    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(true);
        String paginaRequisitada = req.getRequestURL().toString();
               
        if (session.getAttribute("codUsuario") != null){
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
        }
                
        /*String palavraChave;
        palavraChave = obterPalavraChaveDaURL(paginaRequisitada);

        if (!palavraChave.isEmpty()) {

            Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
            Boolean existeUsuarioLogado = usuarioLogado != null;

            if (existeUsuarioLogado) {
                if (usuarioLogado.usuarioTemDireitoDeAcesso(obterDireitoDeAcessoPorPalavraChave(palavraChave))) {
                    chain.doFilter(request, response);
                } else {
                    res.sendRedirect(req.getContextPath() + "/index.jsf");
                }

            } else {
                res.sendRedirect(req.getContextPath() + "/index.jsf");
            }

        } else {
            chain.doFilter(request, response);
        }*/

    }

    public void destroy() {
        
    }   
    
}
