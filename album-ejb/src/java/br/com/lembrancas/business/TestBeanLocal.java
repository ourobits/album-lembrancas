/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.business;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jacoboliveira
 */
@Local
public interface TestBeanLocal {
    public List getImagens() throws Exception;
}
