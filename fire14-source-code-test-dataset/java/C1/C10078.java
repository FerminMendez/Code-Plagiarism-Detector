package jp.funnything.competition.util;

import java.math.BigInteger;

/**
 * Utility for BigInteger
 */
public class BI {
    public static BigInteger ZERO = BigInteger.ZERO;
    public static BigInteger ONE = BigInteger.ONE;

    public static BigInteger add( final BigInteger x , final BigInteger y ) {
        return x.add( y );
    }

    public static BigInteger add( final BigInteger x , final long y ) {
        return add( x , v( y ) );
    }

    public static BigInteger add( final long x , final BigInteger y ) {
        return add( v( x ) , y );
    }

    public static int cmp( final BigInteger x , final BigInteger y ) {
        return x.compareTo( y );
    }

    public static int cmp( final BigInteger x , final long y ) {
        return cmp( x , v( y ) );
    }

    public static int cmp( final long x , final BigInteger y ) {
        return cmp( v( x ) , y );
    }

    public static BigInteger div( final BigInteger x , final BigInteger y ) {
        return x.divide( y );
    }

    public static BigInteger div( final BigInteger x , final long y ) {
        return div( x , v( y ) );
    }

    public static BigInteger div( final long x , final BigInteger y ) {
        return div( v( x ) , y );
    }

    public static BigInteger mod( final BigInteger x , final BigInteger y ) {
        return x.mod( y );
    }

    public static BigInteger mod( final BigInteger x , final long y ) {
        return mod( x , v( y ) );
    }

    public static BigInteger mod( final long x , final BigInteger y ) {
        return mod( v( x ) , y );
    }

    public static BigInteger mul( final BigInteger x , final BigInteger y ) {
        return x.multiply( y );
    }

    public static BigInteger mul( final BigInteger x , final long y ) {
        return mul( x , v( y ) );
    }

    public static BigInteger mul( final long x , final BigInteger y ) {
        return mul( v( x ) , y );
    }

    public static BigInteger sub( final BigInteger x , final BigInteger y ) {
        return x.subtract( y );
    }

    public static BigInteger sub( final BigInteger x , final long y ) {
        return sub( x , v( y ) );
    }

    public static BigInteger sub( final long x , final BigInteger y ) {
        return sub( v( x ) , y );
    }

    public static BigInteger v( final long value ) {
        return BigInteger.valueOf( value );
    }
}
