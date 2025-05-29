/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.hallofmirrors;

/**
 *
 * @author jim
 */
public class Fraction implements Comparable<Fraction> {
    
    public final int n;
    public final int d;

    public Fraction(int i) {
        this(i, 1);
    }
    
    public Fraction(int n, int d) {
        int gcd = GCD(n, d);
        if (gcd != 1) {
            n /= gcd;
            d/= gcd;
        }
        this.n = n;
        this.d = d;
    }
    
    public Fraction (int i, int n, int d) {
        this(i * d + n, d);
    }
    
    public Fraction add(Fraction f) {
        if (d == f.d)
            return new Fraction(n + f.n, d);
        else {
            return new Fraction(n * f.d + d * f.n, d * f.d);
        }
    }
    
    public Fraction substract(Fraction f) {
        if (d == f.d)
            return new Fraction(n - f.n, d);
        else {
            return new Fraction(n * f.d - d * f.n, d * f.d);
        }
    }
    
    public Fraction multiply(Fraction f) {
        return new Fraction(n * f.n, d * f.d);
    }
    
    public Fraction multiply(int i) {
        return new Fraction(n * i, d);
    }
    
    public static int GCD ( int a , int b )
    {
        if (a == 0)
            return b;
        while ( b != 0 )
            {
                int t = b ;
                b = a % b ;
                a = t ;
            }
        return a ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            return compareTo((Fraction)obj) == 0;
        }
        return false;
    }
    
    public int compareTo(Fraction f) {
        return n * f.d - f.n * d;
    }
    
    public int compareTo(int i) {
        return n - i * d;
    }
    
    public boolean isInt() {
        return n % d == 0;
    }
    
    public int floor() {
        if (n == 0 || (n > 0 == d > 0))
            return n / d;
        else
            return n / d - 1;
    }
    
    public Fraction abs() {
        return new Fraction(Math.abs(n), Math.abs(d));
    }
    
    public Fraction fractionalPart() {
        int N = n % d;
        int D = d;
        if (D < 0) {
            N = -N;
            D = -D;
        }
        while (N < 0)
            N += D;
        return new Fraction(N, D);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append("/");
        sb.append(d);
        return sb.toString();
    }
    
    public Fraction divide(int i) {
        return new Fraction(n, d * i);
    }
    
    public Fraction divide(Fraction f) {
        return new Fraction(n * f.d, d * f.n);
    }
    
    
    
}
