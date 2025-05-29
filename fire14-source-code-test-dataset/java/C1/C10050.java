/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.common;

import java.util.ArrayList;

/**
 *
 * @author jim
 */
public interface DatumConverter<T> {
    
    public T getNext(ArrayList<String> list);
    
}
