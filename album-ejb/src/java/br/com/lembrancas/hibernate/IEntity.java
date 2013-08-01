/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lembrancas.hibernate;

import java.io.Serializable;

/**
 *
 * @author jacoboliveira
 */
public interface IEntity<T extends Serializable> extends Serializable{
  public void setId(T id);    
  public T getId();
}
