/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.web.testes;

import br.com.lembrancas.business.TestBeanLocal;
import br.com.lembrancas.entities.Imagens;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author jacoboliveira
 */
public class Testes {
    @EJB
    TestBeanLocal testBeanLocal;
    
    public List<Imagens> getImagens() throws Exception{
        return testBeanLocal.getImagens();        
    }
}
