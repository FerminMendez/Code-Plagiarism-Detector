/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.recyclednumbers;

/**
 *
 * @author jim
 */
public class DataRow {
    public final int A;
    public final int B;
    
    public DataRow(String in) {
        String[] parts = in.split(" ");
        A = Integer.parseInt(parts[0]);
        B = Integer.parseInt(parts[1]);
    }
    
}
