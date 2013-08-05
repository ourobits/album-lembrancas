/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.web;

import javax.annotation.PostConstruct;

/**
 *
 * @author jacoboliveira
 */
public class LembrancasPage {

    boolean visivelDialog;

    public void showDialog() {
        this.visivelDialog = true;
    }

    public void hideDialog() {
        this.visivelDialog = false;
    }

    public void salvar() {
    }

    @PostConstruct
    public void init() {
    }
}
