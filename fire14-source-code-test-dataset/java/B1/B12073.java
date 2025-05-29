package jp.funnything.competition.util;

import java.math.BigDecimal;

/**
 * Utility for BigDeciaml
 */
public class BD {
    public static BigDecimal ZERO = BigDecimal.ZERO;
    public static BigDecimal ONE = BigDecimal.ONE;

    public static BigDecimal add( final BigDecimal x , final BigDecimal y ) {
        return x.add( y );
    }

    public static BigDecimal add( final BigDecimal x , final double y ) {
        return add( x , v( y ) );
    }

    public static BigDecimal add( final double x , final BigDecimal y ) {
        return add( v( x ) , y );
    }

    public static int cmp( final BigDecimal x , final BigDecimal y ) {
        return x.compareTo( y );
    }

    public static int cmp( final BigDecimal x , final double y ) {
        return cmp( x , v( y ) );
    }

    public static int cmp( final double x , final BigDecimal y ) {
        return cmp( v( x ) , y );
    }

    public static BigDecimal div( final BigDecimal x , final BigDecimal y ) {
        return x.divide( y );
    }

    public static BigDecimal div( final BigDecimal x , final double y ) {
        return div( x , v( y ) );
    }

    public static BigDecimal div( final double x , final BigDecimal y ) {
        return div( v( x ) , y );
    }

    public static BigDecimal mul( final BigDecimal x , final BigDecimal y ) {
        return x.multiply( y );
    }

    public static BigDecimal mul( final BigDecimal x , final double y ) {
        return mul( x , v( y ) );
    }

    public static BigDecimal mul( final double x , final BigDecimal y ) {
        return mul( v( x ) , y );
    }

    public static BigDecimal sub( final BigDecimal x , final BigDecimal y ) {
        return x.subtract( y );
    }

    public static BigDecimal sub( final BigDecimal x , final double y ) {
        return sub( x , v( y ) );
    }

    public static BigDecimal sub( final double x , final BigDecimal y ) {
        return sub( v( x ) , y );
    }

    public static BigDecimal v( final double value ) {
        return BigDecimal.valueOf( value );
    }
}
