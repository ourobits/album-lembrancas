/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacoboliveira
 */
public class CampoObrigatorioException extends Exception {
    private List<MensagensErro> camposObrig;

    public void setCamposObrig(List<MensagensErro> camposObrig) {
        this.camposObrig = camposObrig;
    }

    public List<MensagensErro> getCamposObrig() {
        return camposObrig;
    }
    
    /**
     * Creates a new instance of
     * <code>CampoObrigatorioException</code> without detail message.
     */
    public CampoObrigatorioException() {
    }

    /**
     * Constructs an instance of
     * <code>CampoObrigatorioException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public CampoObrigatorioException(String msg) {
        super(msg);
    }
}
