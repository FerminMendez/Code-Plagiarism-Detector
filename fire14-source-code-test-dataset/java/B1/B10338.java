/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

/**
 *
 * @author Jean-Nicolas
 */
public class Pair {
    private int m;
    private int n;

    public Pair(int n, int m) {
        this.m = m;
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        if (this.m != other.m) {
            return false;
        }
        if (this.n != other.n) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.m;
        hash = 89 * hash + this.n;
        return hash;
    }
    
    
}
