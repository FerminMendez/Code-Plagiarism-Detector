/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.common;

/**
 *
 * @author jim
 */
public interface Processor<T> {
    
    public String processDatum(T datum);
    
}
