/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.dancingwiththegooglers;

/**
 *
 * @author jim
 */
public class DataRow {
    
    public final int N;
    public final int S;
    public final int p;
    public final int[] t;
    
    public DataRow(String in) {
        String[] parts = in.split(" ");
        N = Integer.parseInt(parts[0]);
        S = Integer.parseInt(parts[1]);
        p = Integer.parseInt(parts[2]);
        t = new int[N];
        for (int i = 3; i < N + 3; i++) 
            t[i - 3] = Integer.parseInt(parts[i]); 
    }
    
}
