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
public final class MensagemException extends Exception {

    private int tipo;
    private List<String> messages = new ArrayList<String>();

    public MensagemException(Throwable cause) {
        super(cause);
    }

    public MensagemException(String message, Throwable cause) {
        super(message, cause);
    }

    public MensagemException(String message) {
        super(message);
    }

    public MensagemException() {
    }

    public MensagemException(String mensagem, int tipo) {
        adicionarMensagem(mensagem);
        setTipo(tipo);
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getMensagem() {
        StringBuilder str = new StringBuilder();
        for (String msg : messages) {
            str.append(msg);
        }
        return str.toString();
    }

    public void adicionarMensagem(String... msgs) {
        for (String msg : msgs) {
            messages.add(msg + "\n");
        }
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
