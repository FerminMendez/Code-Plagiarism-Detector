/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.hallofmirrors;

/**
 *
 * @author jim
 */
public class Surround {
    
    private Square[][] surround;

    public Surround(Square[][] surround) {
        this.surround = surround;
    }
    
    public Square get(int x, int y) {
        return surround[y][x];
    }
    
}
