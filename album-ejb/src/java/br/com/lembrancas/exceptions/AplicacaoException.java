/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lembrancas.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacob_lisboa
 */
public class AplicacaoException extends Exception {


    private List<String> messages = new ArrayList<String>();

    public AplicacaoException(Throwable cause) {
        super(cause);
    }

    public AplicacaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public AplicacaoException(String message) {
        super(message);
        adicionarMensagem(message);
    }

    public AplicacaoException() {
    }

    public void adicionarMensagem(String msg){
        messages.add(msg);
    }

    public List<String> getMensagens(){
        return messages;
    }
}
