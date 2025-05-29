package dg.gcj.bdancing;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Dmitry
 * Date: 14.04.12
 * Time: 23:29
 * To change this template use File | Settings | File Templates.
 */
public class World {

    private int googlersNumbers;

    private int surprising;

    private int boundaryScore;

    private List<Integer> scores;

    public World(int googlersNumbers, int surprising, int boundaryScore, List<Integer> scores) {
        this.googlersNumbers = googlersNumbers;
        this.surprising = surprising;
        this.boundaryScore = boundaryScore;
        this.scores = scores;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public int getGooglersNumbers() {
        return googlersNumbers;
    }

    public int getSurprising() {
        return surprising;
    }

    public int getBoundaryScore() {
        return boundaryScore;
    }


}
