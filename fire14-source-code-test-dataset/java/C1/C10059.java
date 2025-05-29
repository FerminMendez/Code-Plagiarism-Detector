/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.hallofmirrors;

/**
 *
 * @author jim
 */
public enum Square {
    ME,
    MIRROR,
    EMPTY;
    
    public static Square parse(char in) {
        if (in == '#') return MIRROR;
        else if (in == '.') return EMPTY;
        else if (in == 'X') return ME;
        else return null;
    }
}
