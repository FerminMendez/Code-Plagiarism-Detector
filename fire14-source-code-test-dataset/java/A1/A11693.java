package dg.gcj.bdancing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Dmitry
 * Date: 14.04.12
 * Time: 23:29
 * To change this template use File | Settings | File Templates.
 */
public class Parser {

    private String[] parts;

    private int pos = 0;


    public World parse(String testLine) {
        this.parts = testLine.trim().split(" ");
        this.pos = 0;

        int googlersNumbers = Integer.parseInt(this.parts[pos ++]);
        int surprising = Integer.parseInt(this.parts[pos ++]);
        int boundaryScore = Integer.parseInt(this.parts[pos ++]);

        List<Integer> scores = new ArrayList<Integer>();
        while(pos < this.parts.length)
        {
            scores.add(Integer.parseInt(this.parts[pos++]));
        }

        return new World(googlersNumbers, surprising, boundaryScore, scores);
    }
}
