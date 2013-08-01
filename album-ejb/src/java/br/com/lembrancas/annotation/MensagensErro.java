/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.annotation;

/**
 *
 * @author jacoboliveira
 */
public class MensagensErro {
    private String mensagem;

    public MensagensErro() {
    }

    public MensagensErro(String mensagem) {
        this.mensagem = mensagem;
    }
    
    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
