/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.hallofmirrors;

import java.awt.Point;
import java.util.ArrayList;
import uk.co.epii.codejam.common.DatumConverter;

/**
 *
 * @author jim
 */
public class HallFactory implements DatumConverter<Hall> {

    @Override
    public Hall getNext(ArrayList<String> list) {
        String[] specification = list.remove(0).split(" ");
        int H = Integer.parseInt(specification[0]);
        int W = Integer.parseInt(specification[1]);
        int D = Integer.parseInt(specification[2]);
        FractionPoint meLocation = null;
        Square[][] floor = new Square[H][];
        for (int y = H - 1; y >= 0; y--) {
            floor[y] = new Square[W];
            String line = list.remove(0);
            for (int x = 0; x < W; x++) {
                Square s = Square.parse(line.charAt(x));
                if (s == Square.ME)
                  meLocation = new FractionPoint(
                          new Fraction(x, 1, 2), new Fraction(y, 1 , 2));  
                floor[y][x] = s;
            }
        }
        return new Hall(H, W, D, meLocation, floor);
    }
    
}
