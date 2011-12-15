/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import lusano.criptografiadesenha.util.CriptografiaSenha;
import lusano.marcacaodeconsulta.entity.Consulta;
import lusano.marcacaodeconsulta.entity.ConsultaPK;
import lusano.marcacaodeconsulta.entity.Filial;
import lusano.marcacaodeconsulta.entity.Paciente;
import lusano.marcacaodeconsulta.entity.PacientePK;
import lusano.marcacaodeconsulta.factory.FabricaServico;
import lusano.marcacaodeconsulta.service.ServicoConsulta;
import lusano.marcacaodeconsulta.service.ServicoFilial;
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
    private Filial filialSessao = null;
    private String novaSenha;
    private String novaSenhaConfirmacao;
    private String IdentificacaoBusca = "";
    private String NomeBusca = "";
    private String EmailBusca = "";
    private int AtivoBusca = -1;
    private int codigoFiltroExecutadoListaPacientes = 0;
    
    
    /**
     * @return the filialSessao
     */
    public Filial getFilialSessao() {
        return filialSessao;
    }

    /**
     * @param filialSessao the filialSessao to set
     */
    public void setFilialSessao(Filial filialSessao) {
        this.filialSessao = filialSessao;
    }

    /**
     * @return the IdentificacaoBusca
     */
    public String getIdentificacaoBusca() {
        return IdentificacaoBusca;
    }

    /**
     * @param IdentificacaoBusca the IdentificacaoBusca to set
     */
    public void setIdentificacaoBusca(String IdentificacaoBusca) {
        this.IdentificacaoBusca = IdentificacaoBusca;
    }

    /**
     * @return the NomeBusca
     */
    public String getNomeBusca() {
        return NomeBusca;
    }

    /**
     * @param NomeBusca the NomeBusca to set
     */
    public void setNomeBusca(String NomeBusca) {
        this.NomeBusca = NomeBusca;
    }

    /**
     * @return the EmailBusca
     */
    public String getEmailBusca() {
        return EmailBusca;
    }

    /**
     * @param EmailBusca the EmailBusca to set
     */
    public void setEmailBusca(String EmailBusca) {
        this.EmailBusca = EmailBusca;
    }

    /**
     * @return the AtivoBusca
     */
    public int getAtivoBusca() {
        return AtivoBusca;
    }

    /**
     * @param AtivoBusca the AtivoBusca to set
     */
    public void setAtivoBusca(int AtivoBusca) {
        this.AtivoBusca = AtivoBusca;
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
    
    public PrincipalBean(){
        obterTodosOsPacientesDaFilial();
    }
    
    public void obterTodosOsPacientesDaFilial(){
        ServicoPaciente servico = FabricaServico.obterServicoDePaciente();
        listaPacientes = servico.obterTodosOsPacientesDaFilial(codFilialSessao);
    }
    
    public void obterPacientesDeAcordoComOFiltro(){
        ServicoPaciente servico = FabricaServico.obterServicoDePaciente();
        listaPacientes = servico.obterPacientesFilialDeAcordoComOFiltro(IdentificacaoBusca, NomeBusca, EmailBusca, AtivoBusca, codFilialSessao);
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
        
        if (codigoFiltroExecutadoListaPacientes == 0)
            obterTodosOsPacientesDaFilial();
        else
            obterPacientesDeAcordoComOFiltro();
    }
    
    public void excluirPaciente(ActionEvent e){
        ServicoPaciente servico = FabricaServico.obterServicoDePaciente();
        servico.excluirPaciente(pacienteSelecionado);

        if (codigoFiltroExecutadoListaPacientes == 0)
            obterTodosOsPacientesDaFilial();
        else
            obterPacientesDeAcordoComOFiltro();
    }

    public void cancelarPaciente(ActionEvent e){
        ServicoPaciente servico = FabricaServico.obterServicoDePaciente();
        servico.atualizarPaciente(pacienteSelecionado);
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

    public void cancelarConsulta(ActionEvent e){
        ServicoConsulta servico = FabricaServico.obterServicoDeConsulta();
        servico.atualizarConsulta(consultaSelecionada);
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
    
    public void obterFilialDaSessao(ActionEvent e){
        ServicoFilial servico = FabricaServico.obterServicoDeFilial();
        setFilialSessao(servico.obterFilialPorCodigo(codFilialSessao));
    }
    
    public void salvarFilialDaSessao(ActionEvent e){
        ServicoFilial servico = FabricaServico.obterServicoDeFilial();
        servico.salvarFilial(filialSessao);
    }

    public void cancelarFilialDaSessao(ActionEvent e){
        ServicoFilial servico = FabricaServico.obterServicoDeFilial();
        servico.atualizarFilial(filialSessao);
    }
    
    public void filtrarListaDePacientes(ActionEvent e){
        this.obterPacientesDeAcordoComOFiltro();
        codigoFiltroExecutadoListaPacientes = 1;
    }

    public void zerarFiltroDaListaDePacientes(ActionEvent e){
        IdentificacaoBusca = "";
        NomeBusca = "";
        EmailBusca = "";
        AtivoBusca = -1;
        obterTodosOsPacientesDaFilial();
        codigoFiltroExecutadoListaPacientes = 0;
    }
}
