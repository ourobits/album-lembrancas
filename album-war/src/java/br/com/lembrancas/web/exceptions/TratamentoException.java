/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.web.exceptions;



import br.com.lembrancas.annotation.CampoObrigatorioException;
import br.com.lembrancas.annotation.MensagensErro;
import br.com.lembrancas.exceptions.AplicacaoException;
import br.com.lembrancas.exceptions.BancoDadosException;
import br.com.lembrancas.exceptions.MensagemException;
import br.com.lembrancas.exceptions.SemResultadoParaPesquisaException;
import br.com.lembrancas.util.Constants;
import br.com.lembrancas.web.faces.FacesBean;
import java.util.List;
import javax.ejb.EJBException;

/**
 *
 * @author jacob_lisboa
 */
public class TratamentoException extends FacesBean {

    public TratamentoException() {
    }

    public void tratar(Throwable ex) {
        if (ex instanceof BancoDadosException) {
            BancoDadosException aplicacaoException = (BancoDadosException) ex;
            List<String> msgs = aplicacaoException.getMensagens();
            StringBuilder s = new StringBuilder();
            for (String msg : msgs) {
                s.append(msg).append("\n");
            }
            fatal(s.toString());
        } else if (ex instanceof AplicacaoException) {
            AplicacaoException aplicacaoException = (AplicacaoException) ex;
            List<String> msgs = aplicacaoException.getMensagens();
            StringBuilder s = new StringBuilder();
            for (String msg : msgs) {
                s.append(msg).append("\n");
            }
            error(s.toString());
        } else if (ex instanceof SemResultadoParaPesquisaException) {
            SemResultadoParaPesquisaException semResultadoParaPesquisaException = (SemResultadoParaPesquisaException) ex;
            List<String> msgs = semResultadoParaPesquisaException.getMensagens();
            StringBuilder s = new StringBuilder();
            for (String msg : msgs) {
                s.append(msg).append("\n");
            }
            error(s.toString());
        }else if (ex instanceof MensagemException) {
            MensagemException mensagemException = (MensagemException) ex;
           
            if (mensagemException.getTipo() == Constants.TYPE_ALERT) {
                warn(mensagemException.getMensagem());
            } else if (mensagemException.getTipo() == Constants.TYPE_ERROR) {
                error(mensagemException.getMensagem());
            } else if (mensagemException.getTipo() == Constants.TYPE_SUCCESS) {
                info(mensagemException.getMensagem());
            }else{
                error(mensagemException.getMensagem());
            }
        } else if (ex instanceof EJBException) {
            MensagemException mensagemException = new MensagemException(ex.getMessage(), ex);
            mensagemException.setTipo(Constants.TYPE_ERROR);
            mensagemException.adicionarMensagem(ex.getMessage());
            
            error("Erro EJBException : " + mensagemException.getMensagem());
            
        } else if(ex instanceof CampoObrigatorioException){
            CampoObrigatorioException campoObrigatorioException=(CampoObrigatorioException) ex;
            List<MensagensErro> campos = campoObrigatorioException.getCamposObrig();
            for (MensagensErro mensagensErro : campos) {
                warn(mensagensErro.getMensagem());
            }
        } else {
            log(ex.getMessage(), ex);
            log(ex.getLocalizedMessage(), ex);
            fatal("Erro não controlado Fatal:" + ex.getLocalizedMessage());
            ex.printStackTrace();
        }

    }
}
