/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lusano.marcacaodeconsulta.valueobject;

/**
 *
 * @author mmiranda1984
 */
public class MensagemRetorno {

    private String mensagem;
    private TipoMensagemRetorno tipo;
    private Boolean fechaDialogo;

    public MensagemRetorno(String mensagem, TipoMensagemRetorno tipo) {
        this.mensagem = mensagem;
        this.tipo = tipo;

    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public TipoMensagemRetorno getTipo() {
        return tipo;
    }

    public void setTipo(TipoMensagemRetorno tipo) {
        this.tipo = tipo;
    }

    public Boolean getFechaDialogo() {
        return fechaDialogo;
    }

    public void setFechaDialogo(Boolean fechaDialogo) {
        this.fechaDialogo = fechaDialogo;
    }

    
}
