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
public class SemResultadoParaPesquisaException extends javax.persistence.NoResultException {

    private List<String> messages = new ArrayList<String>();

    public SemResultadoParaPesquisaException(String message) {
        super(message);
        adicionarMensagem(message);
    }

    public SemResultadoParaPesquisaException() {
    }

    public void adicionarMensagem(String msg) {
        messages.add(msg);
    }

    public List<String> getMensagens() {
        return messages;
    }
}
