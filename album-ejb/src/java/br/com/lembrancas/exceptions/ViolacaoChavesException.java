/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.exceptions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author jacob_lisboa
 */
public class ViolacaoChavesException extends ConstraintViolationException{

    private List<String> messages = new ArrayList<String>();

    public ViolacaoChavesException(String message, SQLException root, String sql, String constraintName) {
        super(message, root, sql, constraintName);
    }

    public ViolacaoChavesException(String message, SQLException root, String constraintName) {
        super(message, root, constraintName);
    }

    public void adicionarMensagem(String msg){
        messages.add(msg);
    }

    public List<String> getMensagens(){
        return messages;
    }
}
