/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lembrancas.exceptions;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author jacob_lisboa
 */
public class BancoDadosException extends PersistenceException {


    private List<String> messages = new ArrayList<String>();

    public BancoDadosException() {
    }

    public BancoDadosException(Throwable cause) {
        super(cause);
    }

    public BancoDadosException(String message, Throwable cause) {
        super(message, cause);
    }

    public BancoDadosException(String message) {
        super(message);
    }

    public void adicionarMensagem(String msg){
        messages.add(msg);
    }

    public List<String> getMensagens(){
        return messages;
    }
}
