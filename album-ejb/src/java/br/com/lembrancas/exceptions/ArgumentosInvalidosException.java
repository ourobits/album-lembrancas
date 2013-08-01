/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lembrancas.exceptions;

/**
 *
 * @author jacob_lisboa
 */
public class ArgumentosInvalidosException extends Exception {

    /**
     * Creates a new instance of <code>ArgumentosInvalidosException</code> without detail message.
     */
    public ArgumentosInvalidosException() {
    }


    /**
     * Constructs an instance of <code>ArgumentosInvalidosException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ArgumentosInvalidosException(String msg) {
        super(msg);
    }

    public ArgumentosInvalidosException(Throwable cause) {
        super(cause);
    }

    public ArgumentosInvalidosException(String message, Throwable cause) {
        super(message, cause);
    }

}
