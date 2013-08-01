/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lembrancas.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 *
 * @author jacob_lisboa
 */
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface Campo {
    boolean obrigatorio() default false;    
    String mensagem() default "";
}
