/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lembrancas.exceptions;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;

/**
 *
 * @author jacob_lisboa
 */
public class TransacaoException extends EJBException{

    public TransacaoException(String message, Exception ex) {
        super(message, ex);
        adicionarMensagem(message);
    }

    public TransacaoException(Exception ex) {
        super(ex);
    }

    public TransacaoException(String message) {
        super(message);
        adicionarMensagem(message);
    }

    public TransacaoException() {
    }

    private List<String> messages = new ArrayList<String>();

    public void adicionarMensagem(String msg){
        messages.add(msg);
    }

    public List<String> getMensagens(){
        return messages;
    }
}
