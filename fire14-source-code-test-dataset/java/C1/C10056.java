/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.hallofmirrors;

import java.awt.Point;

/**
 *
 * @author jim
 */
public class Hall {
    public final int H;
    public final int W;
    public final int D;
    public final FractionPoint meLocation;
    private final Square[][] floor;

    public Hall(int H, int W, int D, FractionPoint meLocation, Square[][] floor) {
        this.H = H;
        this.W = W;
        this.D = D;
        this.meLocation = meLocation;
        this.floor = floor;
    }
    
    public RayVector processBoundary(FractionPoint fp, RayVector v) {
        switch (getStep(fp, v)) {
            case CONTINUES:
                return v;
            case EXPIRES:
                return null;
            case REFLECTS_HORIZONTALLY:
                    return new RayVector(-v.x, v.y);
            case REFLECTS_VERTICALLY:
                return new RayVector(v.x, -v.y);
            case INVERTS:
                return new RayVector(-v.x, -v.y);
            default:
                throw new IllegalArgumentException("The getStep has returned "
                        + "an invalid result");
        }
    }
    
    public RayStep getStep(FractionPoint fp, RayVector v) {
        boolean xIsInt = fp.x.isInt();
        boolean yIsInt = fp.y.isInt();
        if (xIsInt && yIsInt) {
            Surround surround = getSurround(new Point(fp.x.floor(), fp.y.floor()));
            int xIndex = v.x > 0 ? 1 : 0;
            int yIndex = v.y > 0 ? 1 : 0;
            Square entering = surround.get(xIndex, yIndex);
            if (entering != Square.MIRROR) 
                    return RayStep.CONTINUES;    
            else if (surround.get(v.x > 0 ? 1 : 0, v.y > 0 ? 0 : 1) == Square.MIRROR && 
                    surround.get(v.x > 0 ? 0 : 1, v.y > 0 ? 1 : 0) == Square.MIRROR)
                return RayStep.INVERTS;
            else if (surround.get(v.x > 0 ? 1 : 0, v.y > 0 ? 0 : 1) != Square.MIRROR && 
                    surround.get(v.x > 0 ? 0 : 1, v.y > 0 ? 1 : 0) != Square.MIRROR)
                return RayStep.EXPIRES;
            else {
                if ((surround.get(0, 0) == Square.MIRROR && surround.get(0, 1) == Square.MIRROR) ||
                        (surround.get(1, 0) == Square.MIRROR && surround.get(1, 1) == Square.MIRROR))
                    return RayStep.REFLECTS_HORIZONTALLY;
                else
                    return RayStep.REFLECTS_VERTICALLY;       
            }
        }
        else if (xIsInt) {
            Square entering = getSquare(
                    fp.x.floor() + (v.x > 0 ? 0 : -1), fp.y.floor());
            if (entering == Square.MIRROR)
                return RayStep.REFLECTS_HORIZONTALLY;
            else
                return RayStep.CONTINUES;
        }
        else if (yIsInt) {
            int x = fp.x.floor();
            int y = fp.y.floor() + (v.y > 0 ? 0 : -1);
            Square entering = getSquare(x, y);
            if (entering == Square.MIRROR)
                return RayStep.REFLECTS_VERTICALLY;
            else
                return RayStep.CONTINUES;
        }
        else 
            throw new IllegalArgumentException("You are not at a boundary!");
    }
    
    public Surround getSurround(Point p) {
        Square[][] surround = new Square[2][];
        surround[0] = new Square[2];
        surround[1] = new Square[2];
        surround[0][0] = getSquare(p.x - 1, p.y - 1);
        surround[1][1] = getSquare(p);
        surround[1][0] = getSquare(p.x - 1, p.y);
        surround[0][1] = getSquare(p.x, p.y - 1);
        return new Surround(surround);
    }
    
    public Square getSquare(int x, int y) {
        return floor[y][x];
    }
    
    public Square getSquare(Point p) {
        return getSquare(p.x, p.y);
    }

}
