/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.bean;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import lusano.criptografiadesenha.util.CriptografiaSenha;
import lusano.marcacaodeconsulta.entity.Consulta;
import lusano.marcacaodeconsulta.entity.ConsultaPK;
import lusano.marcacaodeconsulta.entity.Paciente;
import lusano.marcacaodeconsulta.entity.PacientePK;
import lusano.marcacaodeconsulta.factory.FabricaServico;
import lusano.marcacaodeconsulta.service.ServicoConsulta;
import lusano.marcacaodeconsulta.service.ServicoPaciente;
import lusano.marcacaodeconsulta.service.ServicoUsuario;
import lusano.marcacaodeconsulta.util.JSFUtil;

/**
 *
 * @author mmiranda1984
 */
@ManagedBean
@ViewScoped
public class PrincipalBean implements Serializable{
    
    private Paciente pacienteSelecionado;
    private List<Paciente> listaPacientes;
    private Consulta consultaSelecionada;
    private List<Consulta> listaConsultasDoPaciente;
    private int codFilialSessao = (Integer)JSFUtil.obterObjetoNaSessao("codFilial");
    private String novaSenha;
    private String novaSenhaConfirmacao;
    
    public PrincipalBean(){
        ServicoPaciente servico = FabricaServico.obterServicoDePaciente();
        listaPacientes = servico.obterTodosOsPacientesDaFilial(codFilialSessao);
    }
    
    public void criarNovoPaciente(ActionEvent e){
        PacientePK pacienteChave = new PacientePK();
        pacienteChave.setCodFilialPaciente((Integer)JSFUtil.obterObjetoNaSessao("codFilial"));
        
        pacienteSelecionado = new Paciente();
        pacienteSelecionado.setPacientePK(pacienteChave);
    }

    public void salvarPaciente(ActionEvent e){
        ServicoPaciente servico = FabricaServico.obterServicoDePaciente();
        servico.salvarPaciente(pacienteSelecionado);

        listaPacientes = servico.obterTodosOsPacientesDaFilial(codFilialSessao);
    }
    
    public void excluirPaciente(ActionEvent e){
        ServicoPaciente servico = FabricaServico.obterServicoDePaciente();
        servico.excluirPaciente(pacienteSelecionado);

        listaPacientes = servico.obterTodosOsPacientesDaFilial(codFilialSessao);
    }

    public void criarNovaConsulta(ActionEvent e){
        ConsultaPK consultaChave = new ConsultaPK();
        consultaChave.setCodPacienteConsulta(pacienteSelecionado.getPacientePK().getCodPaciente());
        
        consultaSelecionada = new Consulta();
        consultaSelecionada.setConsultaPK(consultaChave);
    }

    public void salvarConsulta(ActionEvent e){
        ServicoConsulta servico = FabricaServico.obterServicoDeConsulta();
        servico.salvarConsulta(pacienteSelecionado, consultaSelecionada);
        
        carregarListaDeConsultasDoPacienteSelecionado();
    }
    
    public void excluirConsulta(ActionEvent e){
        ServicoConsulta servico = FabricaServico.obterServicoDeConsulta();
        servico.excluirConsulta(pacienteSelecionado, consultaSelecionada);

        carregarListaDeConsultasDoPacienteSelecionado();
    }

    /**
     * @return the pacienteSelecionado
     */
    public Paciente getPacienteSelecionado() {
        if (pacienteSelecionado == null)
            pacienteSelecionado = new Paciente();

        return pacienteSelecionado;
    }

    /**
     * @param pacienteSelecionado the pacienteSelecionado to set
     */
    public void setPacienteSelecionado(Paciente pacienteSelecionado) {
        this.pacienteSelecionado = pacienteSelecionado;
    }

    /**
     * @return the listaPacientes
     */
    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    /**
     * @param listaPacientes the listaPacientes to set
     */
    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }
    
    public String carregarListaDeConsultasDoPacienteSelecionado(){
        if ((pacienteSelecionado != null) & (pacienteSelecionado.getPacientePK() != null)){
            ServicoConsulta servico = FabricaServico.obterServicoDeConsulta();
            listaConsultasDoPaciente = servico.obterTodasAsConsultasDoPaciente(pacienteSelecionado.getPacientePK().getCodPaciente());
            pacienteSelecionado.setConsultaCollection(listaConsultasDoPaciente);
        }
        return null;
    }
    
    public void efetuarLogoff(ActionEvent e){
        JSFUtil.removerObjetoDaSessao("codEmpresa");
        JSFUtil.removerObjetoDaSessao("codFilial");
        JSFUtil.removerObjetoDaSessao("usuario");
        JSFUtil.redirecionarParaAPagina("login.xhtml");
    }

    /**
     * @return the consultaSelecionada
     */
    public Consulta getConsultaSelecionada() {
        if (consultaSelecionada == null)
            consultaSelecionada = new Consulta();

        return consultaSelecionada;
    }

    /**
     * @param consultaSelecionada the consultaSelecionada to set
     */
    public void setConsultaSelecionada(Consulta consultaSelecionada) {
        this.consultaSelecionada = consultaSelecionada;
    }

    /**
     * @return the listaConsultasDoPaciente
     */
    public List<Consulta> getListaConsultasDoPaciente() {
        return listaConsultasDoPaciente;
    }

    /**
     * @param listaConsultasDoPaciente the listaConsultasDoPaciente to set
     */
    public void setListaConsultasDoPaciente(List<Consulta> listaConsultasDoPaciente) {
        this.listaConsultasDoPaciente = listaConsultasDoPaciente;
    }

    /**
     * @return the novaSenha
     */
    public String getNovaSenha() {
        return novaSenha;
    }

    /**
     * @param novaSenha the novaSenha to set
     */
    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    /**
     * @return the novaSenhaConfirmacao
     */
    public String getNovaSenhaConfirmacao() {
        return novaSenhaConfirmacao;
    }

    /**
     * @param novaSenhaConfirmacao the novaSenhaConfirmacao to set
     */
    public void setNovaSenhaConfirmacao(String novaSenhaConfirmacao) {
        this.novaSenhaConfirmacao = novaSenhaConfirmacao;
    }
    
    public void alterarSenha(){
        ServicoUsuario servico = FabricaServico.obterServicoDeUsuario();
        try {
            servico.AlterarSenha(CriptografiaSenha.criptografarSenha(novaSenha), CriptografiaSenha.criptografarSenha(novaSenhaConfirmacao));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void inicializarCamposAlteracaoSenha(ActionEvent e){
        novaSenha = "";
        novaSenhaConfirmacao = "";
    }
    
}
