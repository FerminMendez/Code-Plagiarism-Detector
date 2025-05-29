/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.hallofmirrors;

/**
 *
 * @author jim
 */
public class FractionPoint {
    
    public final Fraction x;
    public final Fraction y;

    public FractionPoint(Fraction x, Fraction y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FractionPoint) {
            FractionPoint fp = (FractionPoint)obj;
            return fp.x.equals(x) && fp.y.equals(y);
        }
        return false;
    }
    
    public FractionPoint add(FractionPoint f) {
        return new FractionPoint(x.add(f.x), y.add(f.y));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(x);
        sb.append(",");
        sb.append(y);
        sb.append(")");
        return sb.toString();
    }
    
    
    
}
