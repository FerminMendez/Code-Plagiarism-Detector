/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.hallofmirrors;

import uk.co.epii.codejam.common.AbstractMain;

/**
 *
 * @author jim
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.err.println("Hello");
        new AbstractMain<Hall>(new HallFactory(), 
                new HallOfMirrorsProcessor()).main(args);
    }
}
