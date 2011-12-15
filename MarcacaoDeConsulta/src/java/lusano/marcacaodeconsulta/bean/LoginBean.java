/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import lusano.criptografiadesenha.util.CriptografiaSenha;
import lusano.marcacaodeconsulta.entity.Empresa;
import lusano.marcacaodeconsulta.entity.Filial;
import lusano.marcacaodeconsulta.entity.Usuario;
import lusano.marcacaodeconsulta.facade.FachadaLogin;
import lusano.marcacaodeconsulta.factory.FabricaFachada;
import lusano.marcacaodeconsulta.factory.FabricaServico;
import lusano.marcacaodeconsulta.service.ServicoUsuario;
import lusano.marcacaodeconsulta.util.JSFUtil;

/**
 *
 * @author mmiranda1984
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private int codEmpresaSelecionada;
    private int codFilialSelecionada;
    private String loginUsuario;
    private String senhaUsuario;
    private List<SelectItem> listaDeFiliaisDaEmpresaSelecionada;
   
    public LoginBean(){

    }
    
    public List<SelectItem> getObterListaDeEmpresasAtivas(){
        ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
        FachadaLogin fachada = FabricaFachada.obterFachadaDeLogin();
        List<Empresa> listaEmpresa = fachada.obterTodasAsEmpresasAtivas();
        for (Empresa empresa : listaEmpresa) {
            SelectItem item = new SelectItem(empresa.getCodEmpresa(), empresa.getNomEmpresa());
            lista.add(item);
        }
        return lista;        
    }
    
    public void carregarListaDeFiliais(){  
        ArrayList<SelectItem> lista = new ArrayList<SelectItem>();
        FachadaLogin fachada = FabricaFachada.obterFachadaDeLogin();
        List<Filial> listaFilial = fachada.obterFiliaisAtivasDaEmpresa(codEmpresaSelecionada);
        for (Filial filial : listaFilial) {
            SelectItem item = new SelectItem(filial.getFilialPK().getCodFilial(), filial.getNomFilial());
            lista.add(item);
        }
        listaDeFiliaisDaEmpresaSelecionada = lista;        
    } 
    
    public void validarUsuario(ActionEvent e){
        ServicoUsuario servico = FabricaServico.obterServicoDeUsuario();
        Usuario usuario;
        try {
            usuario = servico.obterUsuarioValidoParaAcessoAoSistema(codFilialSelecionada, loginUsuario, CriptografiaSenha.criptografarSenha(senhaUsuario));
        } catch (Exception ex) {
            ex.printStackTrace();
            usuario = null;
        }

        if (usuario != null) {
            JSFUtil.adicionarObjetoNaSessao("codEmpresa", codEmpresaSelecionada);
            JSFUtil.adicionarObjetoNaSessao("codFilial", codFilialSelecionada);
            JSFUtil.adicionarObjetoNaSessao("usuario", usuario);
            JSFUtil.redirecionarParaAPagina("principal.xhtml");
        }
    }

    /**
     * @return the codEmpresaSelecionada
     */
    public int getCodEmpresaSelecionada() {
        return codEmpresaSelecionada;
    }

    /**
     * @param codEmpresaSelecionada the codEmpresaSelecionada to set
     */
    public void setCodEmpresaSelecionada(int codEmpresaSelecionada) {
        this.codEmpresaSelecionada = codEmpresaSelecionada;
    }

    /**
     * @return the codFilialSelecionada
     */
    public int getCodFilialSelecionada() {
        return codFilialSelecionada;
    }

    /**
     * @param codFilialSelecionada the codFilialSelecionada to set
     */
    public void setCodFilialSelecionada(int codFilialSelecionada) {
        this.codFilialSelecionada = codFilialSelecionada;
    }

    /**
     * @return the listaDeFiliaisDaEmpresaSelecionada
     */
    public List<SelectItem> getListaDeFiliaisDaEmpresaSelecionada() {
        return listaDeFiliaisDaEmpresaSelecionada;
    }

    /**
     * @param listaDeFiliaisDaEmpresaSelecionada the listaDeFiliaisDaEmpresaSelecionada to set
     */
    public void setListaDeFiliaisDaEmpresaSelecionada(List<SelectItem> listaDeFiliaisDaEmpresaSelecionada) {
        this.setListaDeFiliaisDaEmpresaSelecionada(listaDeFiliaisDaEmpresaSelecionada);
    }

    /**
     * @return the loginUsuario
     */
    public String getLoginUsuario() {
        return loginUsuario;
    }

    /**
     * @param loginUsuario the loginUsuario to set
     */
    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    /**
     * @return the senhaUsuario
     */
    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    /**
     * @param senhaUsuario the senhaUsuario to set
     */
    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public void gerarNovaSenhaEEnviarPorEmail(ActionEvent e){
        ServicoUsuario servico = FabricaServico.obterServicoDeUsuario();
        servico.gerarNovaSenhaEEnviarPorEmail(codFilialSelecionada, loginUsuario);
    }
}
