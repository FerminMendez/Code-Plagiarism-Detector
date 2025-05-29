/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.hallofmirrors;

/**
 *
 * @author jim
 */
public class RayVector {
    
    public final int x;
    public final int y;

    public RayVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RayVector) {
            RayVector v = (RayVector)obj;
            if (v.x * y == v.y * x)
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.x;
        hash = 41 * hash + this.y;
        return hash;
    }
    
    public Fraction getScalarGardient() {
        return new Fraction(Math.abs(y), Math.abs(x));
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
